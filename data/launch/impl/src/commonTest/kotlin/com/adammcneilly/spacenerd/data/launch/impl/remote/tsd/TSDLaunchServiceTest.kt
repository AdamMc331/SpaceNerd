package com.adammcneilly.spacenerd.data.launch.impl.remote.tsd

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Country
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchPad
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.Location
import com.adammcneilly.spacenerd.core.models.Mission
import com.adammcneilly.spacenerd.core.models.Rocket
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.remote.tsd.test.FakeTSDKtorClient
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class TSDLaunchServiceTest {
    private val service = TSDLaunchService(
        client = FakeTSDKtorClient,
    )

    @Test
    @Suppress("LongMethod")
    fun parseLaunchListRequest() =
        runTest {
            val launches = service
                .getLaunches(LaunchListRequest.Upcoming)
                .getOrThrow()

            val expectedLaunch1 = Launch(
                id = "e3df2ecd-c239-472f-95e4-2b89b4f75800",
                name = "Sputnik 8K74PS | Sputnik 1",
                imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
                launchTime = Instant.parse("1957-10-04T19:28:34Z"),
                status = LaunchStatus.Success,
                agency = Agency(
                    id = "66",
                    name = "Soviet Space Program",
                    abbreviation = "CCCP",
                    description = "",
                    logoUrl = "",
                    countries = listOf(
                        Country(
                            id = "123",
                            name = "United States of America",
                            alpha3Code = "USA",
                        ),
                    ),
                ),
                pad = LaunchPad(
                    id = "32",
                    name = "1/5",
                    location = Location(
                        id = "15",
                        name = "Baikonur Cosmodrome, Republic of Kazakhstan",
                    ),
                ),
                mission = Mission(
                    id = "1430",
                    name = "Sputnik 1",
                    description = "First artificial satellite consisting of a 58 cm pressurized aluminium shell containing two 1 W transmitters for a total mass of 83.6 kg.",
                    imageUrl = "",
                    type = "Test Type",
                ),
                rocket = Rocket(
                    id = "468",
                    name = "Sputnik 8K74PS",
                    imageUrl = "",
                    manufacturer = null,
                    description = "",
                    maidenFlight = null,
                    totalLaunches = 0,
                ),
            )

            val expectedLaunch2 = Launch(
                id = "f8c9f344-a6df-4f30-873a-90fe3a7840b3",
                name = "Sputnik 8K74PS | Sputnik 2",
                imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
                launchTime = Instant.parse("1957-11-03T02:30:00Z"),
                status = LaunchStatus.Success,
                agency = Agency(
                    id = "66",
                    name = "Soviet Space Program",
                    abbreviation = "CCCP",
                    description = "",
                    logoUrl = "",
                    countries = listOf(
                        Country(
                            id = "123",
                            name = "United States of America",
                            alpha3Code = "USA",
                        ),
                    ),
                ),
                pad = LaunchPad(
                    id = "32",
                    name = "1/5",
                    location = Location(
                        id = "15",
                        name = "Baikonur Cosmodrome, Republic of Kazakhstan",
                    ),
                ),
                mission = Mission(
                    id = "1431",
                    name = "Sputnik 2",
                    description = "Second artificial satellite and first to carry an animal into orbit.",
                    imageUrl = "",
                    type = "Test Type",
                ),
                rocket = Rocket(
                    id = "468",
                    name = "Sputnik 8K74PS",
                    imageUrl = "",
                    manufacturer = null,
                    description = "",
                    maidenFlight = null,
                    totalLaunches = 0,
                ),
            )

            val expectedLaunches = listOf(expectedLaunch1, expectedLaunch2)

            assertThat(launches).isEqualTo(expectedLaunches)
        }

    @Test
    fun parseLaunchDetail() =
        runTest {
            val launch = service
                .getLaunch("123")
                .getOrThrow()

            val expectedLaunch = Launch(
                id = "e3df2ecd-c239-472f-95e4-2b89b4f75800",
                name = "Sputnik 8K74PS | Sputnik 1",
                imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
                launchTime = Instant.parse("1957-10-04T19:28:34Z"),
                status = LaunchStatus.Success,
                agency = Agency(
                    id = "66",
                    name = "Soviet Space Program",
                    abbreviation = "CCCP",
                    description = "The Soviet space program, was the national space program of the Union of Soviet Socialist Republics (USSR) actived from 1930s until disintegration of the Soviet Union in 1991.\r\n\r\nThe Soviet Union's space program was mainly based on the cosmonautic exploration of space and the development of the expandable launch vehicles, which had been split between many design bureaus competing against each other. Over its 60-years of history, the Russian program was responsible for a number of pioneering feats and accomplishments in the human space flight, including the first intercontinental ballistic missile (R-7), first satellite (Sputnik 1), first animal in Earth orbit (the dog Laika on Sputnik 2), first human in space and Earth orbit (cosmonaut Yuri Gagarin on Vostok 1), first woman in space and Earth orbit (cosmonaut Valentina Tereshkova on Vostok 6), first spacewalk (cosmonaut Alexei Leonov on Voskhod 2), first Moon impact (Luna 2), first image of the far side of the Moon (Luna 3) and unmanned lunar soft landing (Luna 9), first space rover (Lunokhod 1), first sample of lunar soil automatically extracted and brought to Earth (Luna 16), and first space station (Salyut 1). Further notable records included the first interplanetary probes: Venera 1 and Mars 1 to fly by Venus and Mars, respectively, Venera 3 and Mars 2 to impact the respective planet surface, and Venera 7 and Mars 3 to make soft landings on these planets.",
                    logoUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/soviet2520space2520program_logo_20191229081307.png",
                    countries = listOf(
                        Country(
                            id = "123",
                            name = "United States of America",
                            alpha3Code = "USA",
                        ),
                    ),
                ),
                pad = LaunchPad(
                    id = "32",
                    name = "1/5",
                    location = Location(
                        id = "15",
                        name = "Baikonur Cosmodrome, Republic of Kazakhstan",
                    ),
                ),
                mission = Mission(
                    id = "1430",
                    name = "Sputnik 1",
                    description = "First artificial satellite consisting of a 58 cm pressurized aluminium shell containing two 1 W transmitters for a total mass of 83.6 kg.",
                    imageUrl = "",
                    type = "Test Type",
                ),
                rocket = Rocket(
                    id = "468",
                    name = "Sputnik 8K74PS",
                    imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
                    manufacturer = Agency(
                        id = "1000",
                        name = "Energia",
                        abbreviation = "OKB-1",
                        description = "",
                        logoUrl = "",
                        countries = listOf(
                            Country(
                                id = "123",
                                name = "United States of America",
                                alpha3Code = "USA",
                            ),
                        ),
                    ),
                    description = "An early Russian rocket designed by Sergei Korolev in the Soviet Union",
                    maidenFlight = LocalDate.parse("1957-10-04"),
                    totalLaunches = 2,
                ),
            )

            assertThat(launch).isEqualTo(expectedLaunch)
        }
}
