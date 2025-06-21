package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import com.adammcneilly.spacenerd.shared.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchStatusDisplayModel
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
