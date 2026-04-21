package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Country
import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.remote.tsd.test.FakeTSDKtorClient
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
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
                agencies = listOf(
                    Agency(
                        id = "44",
                        name = "National Aeronautics and Space Administration",
                        abbreviation = "NASA",
                        description = "The National Aeronautics and Space Administration is an independent agency of the executive branch of the United States federal government responsible for the civilian space program, as well as aeronautics and aerospace research. NASA have many launch facilities but most are inactive. The most commonly used pad will be LC-39B at Kennedy Space Center in Florida.",
                        logoUrl = "nasaImageUrl",
                        countries = listOf(
                            Country(
                                id = "2",
                                name = "United States of America",
                                alpha3Code = "USA",
                            ),
                        ),
                    ),
                ),
                founded = LocalDate(1998, 11, 20),
            )

            val expectedTiangongStation = SpaceStation(
                id = "18",
                name = "Tiangong space station",
                status = SpaceStationStatus.Active,
                imageUrl = "tiangongImageUrl",
                agencies = listOf(
                    Agency(
                        id = "88",
                        name = "China Aerospace Science and Technology Corporation",
                        abbreviation = "CASC",
                        description = "The China Aerospace Science and Technology Corporation (CASC) is the main contractor for the Chinese space program. It is state-owned and has a number of subordinate entities which design, develop and manufacture a range of spacecraft, launch vehicles, strategic and tactical missile systems, and ground equipment. It was officially established in July 1999 as part of a Chinese government reform drive, having previously been one part of the former China Aerospace Corporation. Various incarnations of the program date back to 1956.",
                        logoUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/china2520aerospace2520science2520and2520technology2520corporation_logo_20220826093937.png",
                        countries = listOf(
                            Country(
                                id = "6",
                                name = "China",
                                alpha3Code = "CHN",
                            ),
                        ),
                    ),
                ),
                founded = LocalDate(2021, 4, 29),
            )

            val expectedStations = listOf(expectedIss, expectedTiangongStation)
            assertThat(stations).isEqualTo(expectedStations)
        }
}
