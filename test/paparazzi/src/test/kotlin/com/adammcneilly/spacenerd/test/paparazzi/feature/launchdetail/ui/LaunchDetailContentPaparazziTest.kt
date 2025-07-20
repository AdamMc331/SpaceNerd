package com.adammcneilly.spacenerd.test.paparazzi.feature.launchdetail.ui

import androidx.compose.foundation.layout.PaddingValues
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchPad
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.Location
import com.adammcneilly.spacenerd.core.models.Mission
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailContent
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class LaunchDetailContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            LaunchDetailContent(
                state = LaunchDetailUiState.default(),
                contentPadding = PaddingValues(),
            )
        }
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun renderDefault() {
        val launch = Launch(
            id = "123",
            name = "Falcon 9 Block 5 | Starlink Group 12-19",
            imageUrl = "",
            status = LaunchStatus.Go,
            agency = Agency(
                id = "123",
                name = "SpaceX",
                abbreviation = "SpX",
                description = "Space Exploration Technologies Corp., known as SpaceX, " +
                    "is an American aerospace manufacturer and space transport services company " +
                    "headquartered in Hawthorne, California. It was founded in 2002 by entrepreneur " +
                    "Elon Musk with the goal of reducing space transportation costs and enabling the " +
                    "colonization of Mars. SpaceX operates from many pads, on the East Coast of the US " +
                    "they operate from SLC-40 at Cape Canaveral Space Force Station and historic LC-39A " +
                    "at Kennedy Space Center. They also operate from SLC-4E at Vandenberg Space Force Base, " +
                    "California, usually for polar launches. Another launch site is being developed " +
                    "at Boca Chica, Texas.",
                logoUrl = "",
            ),
            mission = Mission(
                id = "123",
                name = "Starlink Group 12-19",
                description = "A batch of 27 satellites for the Starlink mega-constellation" +
                    " - SpaceX's project for space-based Internet communication system.",
                imageUrl = "",
            ),
            launchTime = Instant.parse("2025-01-01T00:00:00Z"),
            pad = LaunchPad(
                id = "123",
                name = "Launch Pad 39A",
                location = Location(
                    id = "123",
                    name = "Cape Canaveral SFS, FL, USA",
                ),
            ),
        )

        val displayModel = LaunchDisplayModel(launch)

        snapshot(
            screenPaddingDp = 0,
        ) {
            LaunchDetailContent(
                state = LaunchDetailUiState(
                    launch = displayModel,
                ),
                contentPadding = PaddingValues(),
            )
        }
    }
}
