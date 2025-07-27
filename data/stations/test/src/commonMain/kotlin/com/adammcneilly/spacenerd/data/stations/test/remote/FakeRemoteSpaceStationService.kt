package com.adammcneilly.spacenerd.data.stations.test.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService

class FakeRemoteSpaceStationService : RemoteSpaceStationService {
    val stationsByRequest: MutableMap<SpaceStationListRequest, Result<List<SpaceStation>>> = mutableMapOf()

    override suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>> {
        return stationsByRequest[request]!!
    }
}
