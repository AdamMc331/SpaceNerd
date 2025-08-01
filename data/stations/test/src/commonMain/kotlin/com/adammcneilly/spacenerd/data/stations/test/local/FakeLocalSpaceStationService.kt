package com.adammcneilly.spacenerd.data.stations.test.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeLocalSpaceStationService : LocalSpaceStationService {
    private val savedStations: MutableList<SpaceStation> = mutableListOf()
    private val stationsByRequest: MutableMap<SpaceStationListRequest, List<SpaceStation>> = mutableMapOf()
    private val stationRequestsMade: MutableList<SpaceStationListRequest> = mutableListOf()

    override suspend fun saveStations(
        stations: List<SpaceStation>,
    ) {
        this.savedStations.addAll(stations)
    }

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        this.stationRequestsMade.add(request)
        return flowOf(stationsByRequest[request]!!)
    }

    fun verifyStationsSaved(
        stations: List<SpaceStation>,
    ) {
        assertThat(savedStations).containsAllIn(stations)
    }

    fun verifyStationRequestMade(
        request: SpaceStationListRequest,
    ) {
        assertThat(stationRequestsMade).contains(request)
    }

    fun verifyNoRequestsMade() {
        assertThat(stationRequestsMade).isEmpty()
    }
}
