package com.adammcneilly.spacenerd.data.stations.test.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeLocalSpaceStationService : LocalSpaceStationService {
    private val savedStations: MutableList<SpaceStation> = mutableListOf()
    private val stationsByRequest: MutableMap<SpaceStationListRequest, List<SpaceStation>> = mutableMapOf()

    override suspend fun saveStations(
        stations: List<SpaceStation>,
    ) {
        this.savedStations += stations
    }

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        return flowOf(stationsByRequest[request]!!)
    }

    fun getSavedStations(): List<SpaceStation> {
        return this.savedStations
    }
}
