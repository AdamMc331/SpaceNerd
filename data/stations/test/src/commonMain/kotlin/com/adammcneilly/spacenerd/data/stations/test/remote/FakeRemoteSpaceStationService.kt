package com.adammcneilly.spacenerd.data.stations.test.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService
import com.varabyte.truthish.assertThat

class FakeRemoteSpaceStationService : RemoteSpaceStationService {
    private val stationsByRequest: MutableMap<SpaceStationListRequest, Result<List<SpaceStation>>> = mutableMapOf()
    private val stationRequestsMade: MutableList<SpaceStationListRequest> = mutableListOf()

    override suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>> {
        stationRequestsMade.add(request)
        return stationsByRequest[request]!!
    }

    fun setResultForRequest(
        request: SpaceStationListRequest,
        result: Result<List<SpaceStation>>,
    ) {
        stationsByRequest[request] = result
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
