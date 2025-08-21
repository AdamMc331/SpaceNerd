package com.adammcneilly.spacenerd.data.stations.api.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest

/**
 * Defines any requests to a remote data source for space station information.
 *
 * All functions inside this interface should be suspending, and return a singular [Result]
 * entity once the network request has completed.
 */
interface RemoteSpaceStationService {
    suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>>

    suspend fun getStation(
        id: String,
    ): Result<SpaceStation>
}
