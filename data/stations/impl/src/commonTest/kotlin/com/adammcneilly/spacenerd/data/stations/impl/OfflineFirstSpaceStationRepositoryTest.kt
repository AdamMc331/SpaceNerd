package com.adammcneilly.spacenerd.data.stations.impl

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.datetime.test.FakeDateTimeProvider
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.data.cache.test.FakeCacheTimestampRepository
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.impl.OfflineFirstSpaceStationRepository.Companion.CACHE_KEY_STATIONS_PREFIX
import com.adammcneilly.spacenerd.data.stations.test.local.FakeLocalSpaceStationService
import com.adammcneilly.spacenerd.data.stations.test.remote.FakeRemoteSpaceStationService
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class OfflineFirstSpaceStationRepositoryTest {
    private val dateTimeProvider = FakeDateTimeProvider()
    private val localSpaceStationService = FakeLocalSpaceStationService()
    private val remoteSpaceStationService = FakeRemoteSpaceStationService()
    private val cacheTimestampRepository = FakeCacheTimestampRepository(
        dateTimeProvider = dateTimeProvider,
    )

    private val repository = OfflineFirstSpaceStationRepository(
        localSpaceStationService = localSpaceStationService,
        remoteSpaceStationService = remoteSpaceStationService,
        cacheTimestampRepository = cacheTimestampRepository,
    )

    @Test
    fun `request calls remote service if no cache timestamp`() =
        runTest {
            val now = Instant.parse("2023-01-01T00:00:00Z")
            val request = SpaceStationListRequest()
            val stations = listOf(testSpaceStation)
            val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"
            dateTimeProvider.time = now
            localSpaceStationService.setStationsByRequest(request, stations)
            remoteSpaceStationService.setResultForRequest(request, Result.success(stations))
            cacheTimestampRepository.setTimestampForKey(cacheKey, null)

            repository.getStations(request).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(stations)

                remoteSpaceStationService.verifyRequestMade(request)
                localSpaceStationService.verifyStationsSaved(stations)
                cacheTimestampRepository.verifyTimestampSet(cacheKey)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `request calls remote service if cache over 1 hour ago`() =
        runTest {
            val cacheTime = Instant.parse("2023-01-01T00:00:00Z")
            val now = cacheTime.plus(2.hours)
            val request = SpaceStationListRequest()
            val stations = listOf(testSpaceStation)
            val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"
            dateTimeProvider.time = now
            localSpaceStationService.setStationsByRequest(request, stations)
            remoteSpaceStationService.setResultForRequest(request, Result.success(stations))
            cacheTimestampRepository.setTimestampForKey(cacheKey, cacheTime)

            repository.getStations(request).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(stations)

                remoteSpaceStationService.verifyRequestMade(request)
                localSpaceStationService.verifyStationsSaved(stations)
                cacheTimestampRepository.verifyTimestampSet(cacheKey)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `request skips remote service if cache timestamp set within 1 hour`() =
        runTest {
            val cacheTime = Instant.parse("2023-01-01T00:00:00Z")
            val now = cacheTime.plus(30.minutes)
            val request = SpaceStationListRequest()
            val stations = listOf(testSpaceStation)
            val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"
            dateTimeProvider.time = now
            localSpaceStationService.setStationsByRequest(request, stations)
            remoteSpaceStationService.setResultForRequest(request, Result.success(stations))
            cacheTimestampRepository.setTimestampForKey(cacheKey, cacheTime)

            repository.getStations(request).test {
                val repoResponse = awaitItem()
                assertThat(repoResponse).isEqualTo(stations)

                remoteSpaceStationService.verifyNoRequestsMade()
                localSpaceStationService.verifyNoStationsSaved()
                cacheTimestampRepository.verifyNoTimestampSet()

                cancelAndIgnoreRemainingEvents()
            }
        }
}
