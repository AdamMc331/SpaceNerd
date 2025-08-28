package com.adammcneilly.spacenerd.test.paparazzi.feature.stationdetail.ui

import androidx.compose.foundation.layout.PaddingValues
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testLaunch
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailContent
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailUiState
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailContent
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime

class StationDetailContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            StationDetailContent(
                state = StationDetailUiState.default(),
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
            StationDetailContent(
                state = StationDetailUiState(
                    station = SpaceStationDisplayModel(testSpaceStation),
                ),
                contentPadding = PaddingValues(),
            )
        }
    }
}
