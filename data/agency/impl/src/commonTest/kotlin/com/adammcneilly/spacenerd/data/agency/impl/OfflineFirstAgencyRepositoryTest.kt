package com.adammcneilly.spacenerd.data.agency.impl

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.models.test.testAgency
import com.adammcneilly.spacenerd.data.agency.api.local.LocalAgencyService
import com.adammcneilly.spacenerd.data.agency.api.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.data.agency.impl.OfflineFirstAgencyRepository.Companion.CACHE_KEY_AGENCY_PREFIX
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.varabyte.truthish.assertThat
import dev.mokkery.MockMode
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.matcher.eq
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode
import dev.mokkery.verifySuspend
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class OfflineFirstAgencyRepositoryTest {
    private val localAgencyService = mock<LocalAgencyService>(mode = MockMode.autoUnit)
    private val remoteAgencyService = mock<RemoteAgencyService>(mode = MockMode.autoUnit)
    private val cacheTimestampRepository = mock<CacheTimestampRepository>(mode = MockMode.autoUnit)

    private val repository = OfflineFirstAgencyRepository(
        localAgencyService = localAgencyService,
        remoteAgencyService = remoteAgencyService,
        cacheTimestampRepository = cacheTimestampRepository,
    )

    @Test
    fun `request calls remote service with sync required`() =
        runTest {
            val id = "agencyId"
            val cacheKey = "$CACHE_KEY_AGENCY_PREFIX$id"

            every {
                localAgencyService.getAgency(id)
            } returns flowOf(testAgency)

            everySuspend {
                remoteAgencyService.getAgency(id)
            } returns Result.success(testAgency)

            everySuspend {
                cacheTimestampRepository.shouldSyncWithServer(eq(cacheKey), any())
            } returns true

            repository.getAgency(id).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(testAgency)

                verifySuspend {
                    remoteAgencyService.getAgency(id)
                }

                verifySuspend {
                    localAgencyService.saveAgency(testAgency)
                }

                verifySuspend {
                    cacheTimestampRepository.setCacheTimestamp(cacheKey)
                }

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `request skips remote service without sync required`() =
        runTest {
            val id = "agency_id"
            val cacheKey = "$CACHE_KEY_AGENCY_PREFIX$id"

            every {
                localAgencyService.getAgency(id)
            } returns flowOf(testAgency)

            everySuspend {
                remoteAgencyService.getAgency(id)
            } returns Result.success(testAgency)

            everySuspend {
                cacheTimestampRepository.shouldSyncWithServer(eq(cacheKey), any())
            } returns false

            repository.getAgency(id).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(testAgency)

                verifySuspend(
                    mode = VerifyMode.exactly(0),
                ) {
                    remoteAgencyService.getAgency(any())
                }

                verifySuspend(
                    mode = VerifyMode.exactly(0),
                ) {
                    localAgencyService.saveAgency(any())
                }

                verifySuspend(
                    mode = VerifyMode.exactly(0),
                ) {
                    cacheTimestampRepository.setCacheTimestamp(any())
                }

                cancelAndIgnoreRemainingEvents()
            }
        }
}
