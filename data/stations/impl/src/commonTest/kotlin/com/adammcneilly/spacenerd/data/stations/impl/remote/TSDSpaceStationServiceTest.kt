package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class TSDSpaceStationServiceTest {
    private lateinit var service: TSDSpaceStationService

    private suspend fun buildService() {
        val client = FakeKtorClient(
            mockResponses = mapOf(
                "/space_stations" to "space_stations_success.json",
            ),
        )

        service = TSDSpaceStationService(
            client = client,
        )
    }

    @Test
    fun parseSpaceStationsSuccess() =
        runTest {
            buildService()

            val result = service.getStations(SpaceStationListRequest())

            assertTrue(result.isSuccess)
        }
}
