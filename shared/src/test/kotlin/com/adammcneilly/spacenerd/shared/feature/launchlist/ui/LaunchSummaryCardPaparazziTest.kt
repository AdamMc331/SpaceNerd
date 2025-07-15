package com.adammcneilly.spacenerd.shared.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchStatusDisplayModel
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import org.junit.Test

class LaunchSummaryCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        val launch = LaunchDisplayModel.placeholder()

        snapshot {
            LaunchSummaryCard(
                launch = launch,
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
            agency = null,
            mission = null,
            subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
        )

        snapshot {
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }
}
