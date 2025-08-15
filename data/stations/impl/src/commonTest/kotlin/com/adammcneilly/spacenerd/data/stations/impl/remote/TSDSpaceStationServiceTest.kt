package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.remote.tsd.test.FakeTSDKtorClient
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TSDSpaceStationServiceTest {
    private val service = TSDSpaceStationService(
        client = FakeTSDKtorClient,
    )

    @Test
    fun parseSpaceStationsSuccess() =
        runTest {
            val stations = service
                .getStations(SpaceStationListRequest())
                .getOrThrow()

            val expectedIss = SpaceStation(
                id = "4",
                name = "International Space Station",
                status = SpaceStationStatus.Active,
                imageUrl = "issImageUrl",
            )

            val expectedTiangongStation = SpaceStation(
                id = "18",
                name = "Tiangong space station",
                status = SpaceStationStatus.Active,
                imageUrl = "tiangongImageUrl",
            )

            val expectedStations = listOf(expectedIss, expectedTiangongStation)
            assertThat(stations).isEqualTo(expectedStations)
        }
}
