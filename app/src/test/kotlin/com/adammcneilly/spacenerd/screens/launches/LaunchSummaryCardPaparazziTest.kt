package com.adammcneilly.spacenerd.screens.launches

import com.adammcneilly.spacenerd.BasePaparazziTest
import com.adammcneilly.spacenerd.R
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
            image = ImageDisplayModel.AndroidLocal(R.drawable.falcon9),
            status = LaunchStatusDisplayModel(LaunchStatus.Go),
            subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
        )

        snapshot {
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }
}
