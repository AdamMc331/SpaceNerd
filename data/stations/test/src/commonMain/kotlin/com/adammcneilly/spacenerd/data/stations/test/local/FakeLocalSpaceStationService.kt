package com.adammcneilly.spacenerd.data.stations.test.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeLocalSpaceStationService : LocalSpaceStationService {
    private val stations: MutableList<SpaceStation> = mutableListOf()

    override suspend fun saveStations(
        stations: List<SpaceStation>,
    ) {
        this.stations += stations
    }

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        val filteredStations = stations.filter { station ->
            (request.status == null || request.status == station.status)
        }

        return flowOf(filteredStations)
    }
}
