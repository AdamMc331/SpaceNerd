package com.adammcneilly.spacenerd.shared.feature.launchlist.ui

import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import com.adammcneilly.spacenerd.shared.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchStatusDisplayModel
import com.adammcneilly.spacenerd.shared.core.models.LaunchStatus
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
            subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
        )

        snapshot {
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }
}
