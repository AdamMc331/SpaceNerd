package com.adammcneilly.spacenerd.data.launch.impl.remote.tsd

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchPad
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.Location
import com.adammcneilly.spacenerd.core.models.Mission
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.remote.tsd.test.FakeTSDKtorClient
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class TSDLaunchServiceTest {
    private val service = TSDLaunchService(
        client = FakeTSDKtorClient,
    )

    @Test
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
                    description = "First artificial satellite consisting of a 58 cm pressurized aluminium shell containing two 1 W " +
                        "transmitters for a total mass of 83.6 kg.",
                    imageUrl = "",
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
                    description = "",
                    logoUrl = "",
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
                    description = "First artificial satellite consisting of a 58 cm pressurized aluminium shell containing two 1 W " +
                        "transmitters for a total mass of 83.6 kg.",
                    imageUrl = "",
                ),
            )

            assertThat(launch).isEqualTo(expectedLaunch)
        }
}
