package com.adammcneilly.spacenerd.data.stations.impl

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService
import com.adammcneilly.spacenerd.data.stations.impl.OfflineFirstSpaceStationRepository.Companion.CACHE_KEY_STATIONS_PREFIX
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

class OfflineFirstSpaceStationRepositoryTest {
    private val localSpaceStationService = mock<LocalSpaceStationService>(mode = MockMode.autoUnit)
    private val remoteSpaceStationService = mock<RemoteSpaceStationService>(mode = MockMode.autoUnit)
    private val cacheTimestampRepository = mock<CacheTimestampRepository>(mode = MockMode.autoUnit)

    private val repository = OfflineFirstSpaceStationRepository(
        localSpaceStationService = localSpaceStationService,
        remoteSpaceStationService = remoteSpaceStationService,
        cacheTimestampRepository = cacheTimestampRepository,
    )

    @Test
    fun `list request calls remote service with sync required`() =
        runTest {
            val request = SpaceStationListRequest()
            val stations = listOf(testSpaceStation)
            val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"

            every {
                localSpaceStationService.getStations(request)
            } returns flowOf(stations)

            everySuspend {
                remoteSpaceStationService.getStations(request)
            } returns Result.success(stations)

            everySuspend {
                cacheTimestampRepository.shouldSyncWithServer(eq(cacheKey), any())
            } returns true

            repository.getStations(request).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(stations)

                verifySuspend {
                    remoteSpaceStationService.getStations(request)
                }

                verifySuspend {
                    localSpaceStationService.saveStations(
                        stations = stations,
                        replace = false,
                    )
                }

                verifySuspend {
                    cacheTimestampRepository.setCacheTimestamp(cacheKey)
                }

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `list request skips remote service without sync required`() =
        runTest {
            val request = SpaceStationListRequest()
            val stations = listOf(testSpaceStation)
            val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"

            every {
                localSpaceStationService.getStations(request)
            } returns flowOf(stations)

            everySuspend {
                remoteSpaceStationService.getStations(request)
            } returns Result.success(stations)

            everySuspend {
                cacheTimestampRepository.shouldSyncWithServer(eq(cacheKey), any())
            } returns false

            repository.getStations(request).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(stations)

                verifySuspend(
                    mode = VerifyMode.exactly(0),
                ) {
                    remoteSpaceStationService.getStations(any())
                }

                verifySuspend(
                    mode = VerifyMode.exactly(0),
                ) {
                    localSpaceStationService.saveStations(
                        stations = any(),
                        replace = any(),
                    )
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
