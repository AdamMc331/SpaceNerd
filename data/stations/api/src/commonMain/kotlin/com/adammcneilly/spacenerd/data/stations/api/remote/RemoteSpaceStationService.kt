package com.adammcneilly.spacenerd.data.stations.api.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest

interface RemoteSpaceStationService {
    suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>>
}
