package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import com.adammcneilly.spacenerd.shared.core.displaymodels.AgencyDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchStatusDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.MissionDisplayModel
import com.adammcneilly.spacenerd.shared.core.models.LaunchStatus
import kotlin.test.Test

class LaunchDetailContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            LaunchDetailContent(
                state = LaunchDetailUiState.default(),
            )
        }
    }

    @Test
    fun renderDefault() {
        val launch = LaunchDisplayModel(
            id = "123",
            name = "Falcon 9 Block 5 | Starlink Group 12-19",
            image = ImageDisplayModel.Placeholder,
            status = LaunchStatusDisplayModel(LaunchStatus.Go),
            agency = AgencyDisplayModel(
                id = "123",
                name = "SpaceX",
                description = "Space Exploration Technologies Corp., known as SpaceX, " +
                    "is an American aerospace manufacturer and space transport services company " +
                    "headquartered in Hawthorne, California. It was founded in 2002 by entrepreneur " +
                    "Elon Musk with the goal of reducing space transportation costs and enabling the " +
                    "colonization of Mars. SpaceX operates from many pads, on the East Coast of the US " +
                    "they operate from SLC-40 at Cape Canaveral Space Force Station and historic LC-39A " +
                    "at Kennedy Space Center. They also operate from SLC-4E at Vandenberg Space Force Base, " +
                    "California, usually for polar launches. Another launch site is being developed " +
                    "at Boca Chica, Texas.",
                logo = ImageDisplayModel.Placeholder,
            ),
            mission = MissionDisplayModel(
                id = "123",
                name = "Starlink Group 12-19",
                description = "A batch of 27 satellites for the Starlink mega-constellation - SpaceX's project for space-based Internet communication system.",
                image = ImageDisplayModel.Placeholder,
            ),
            subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
        )

        snapshot(
            screenPaddingDp = 0,
        ) {
            LaunchDetailContent(
                state = LaunchDetailUiState(
                    launch = launch,
                ),
            )
        }
    }
}
