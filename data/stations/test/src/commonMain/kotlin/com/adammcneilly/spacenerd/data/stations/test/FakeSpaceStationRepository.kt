package com.adammcneilly.spacenerd.data.stations.test

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSpaceStationRepository : SpaceStationRepository {
    val stationsByRequest: MutableMap<SpaceStationListRequest, List<SpaceStation>> = mutableMapOf()

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        return flowOf(stationsByRequest[request]!!)
    }
}
