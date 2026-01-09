package com.adammcneilly.spacenerd.test.paparazzi.feature.launchdetail.ui

import androidx.compose.foundation.layout.PaddingValues
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testLaunch
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailContent
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlinx.datetime.TimeZone
import kotlin.test.Test
import kotlin.time.ExperimentalTime

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
        snapshot(
            screenPaddingDp = 0,
        ) {
            LaunchDetailContent(
                state = LaunchDetailUiState(
                    launch = LaunchDisplayModel(
                        launch = testLaunch,
                        timeZone = TimeZone.UTC,
                    ),
                ),
                contentPadding = PaddingValues(),
            )
        }
    }
}
