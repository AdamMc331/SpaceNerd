package com.adammcneilly.spacenerd.data.stations.impl

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstSpaceStationRepository(
    private val localSpaceStationService: LocalSpaceStationService,
    private val remoteSpaceStationService: RemoteSpaceStationService,
    private val cacheTimestampRepository: CacheTimestampRepository,
) : SpaceStationRepository {
    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        return localSpaceStationService.getStations(request)
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = "$CACHE_KEY_STATIONS_PREFIX$request"

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteSpaceStationService.getStations(request)

                        val stations = response.getOrNull()
                        if (stations != null) {
                            localSpaceStationService.saveStations(stations)
                            cacheTimestampRepository.setCacheTimestamp(cacheKey)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching stations: $request: $error")
                        }
                    }
                }
            }
    }

    companion object {
        private const val CACHE_KEY_STATIONS_PREFIX = "space_stations_"
    }
}
