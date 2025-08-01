package com.adammcneilly.spacenerd.data.stations.test

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSpaceStationRepository : SpaceStationRepository {
    val stationsByRequest: MutableMap<SpaceStationListRequest, List<SpaceStation>> = mutableMapOf()
    val stationRequestsMade: MutableList<SpaceStationListRequest> = mutableListOf()

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        stationRequestsMade.add(request)
        return flowOf(stationsByRequest[request]!!)
    }

    fun verifyRequestMade(
        request: SpaceStationListRequest,
    ) {
        assertThat(stationRequestsMade).contains(request)
    }

    fun verifyNoRequestsMade() {
        assertThat(stationRequestsMade).isEmpty()
    }
}
