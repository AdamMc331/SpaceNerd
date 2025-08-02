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
                imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/" +
                    "international2520space2520station_image_20190220215716.jpeg",
            )

            val expectedTiangongStation = SpaceStation(
                id = "18",
                name = "Tiangong space station",
                status = SpaceStationStatus.Active,
                imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/" +
                    "tiangong_space__image_20231031004146.png",
            )

            val expectedStations = listOf(expectedIss, expectedTiangongStation)
            assertThat(stations).isEqualTo(expectedStations)
        }
}
