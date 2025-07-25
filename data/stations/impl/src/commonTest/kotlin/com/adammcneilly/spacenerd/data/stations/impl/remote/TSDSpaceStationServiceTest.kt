package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.impl.remote.mocks.mockTsdSpaceStationListResponse
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TSDSpaceStationServiceTest {
    private val mockClient = FakeKtorClient(
        mockResponses = mapOf(
            "/space_stations" to mockTsdSpaceStationListResponse,
        ),
    )

    private val service = TSDSpaceStationService(
        client = mockClient,
    )

    @Test
    fun parseSpaceStationsSuccess() =
        runTest {
            val stations = service
                .getStations(SpaceStationListRequest())
                .getOrThrow()

            assertThat(stations.size).isEqualTo(2)
            assertThat(stations[0].name).isEqualTo("International Space Station")
            assertThat(stations[1].name).isEqualTo("Tiangong space station")
        }
}
