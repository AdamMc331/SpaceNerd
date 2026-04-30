package com.adammcneilly.spacenerd.test.paparazzi.feature.astronautlist.ui

import androidx.compose.foundation.layout.PaddingValues
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.core.models.test.testAstronaut
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListContent
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test

class AstronautListContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderLoading() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            AstronautListContent(
                state = AstronautListUiState.default().copy(
                    syncStatus = SyncStatus.Initial,
                ),
            )
        }
    }

    @Test
    fun renderDefault() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            AstronautListContent(
                state = AstronautListUiState.default().copy(
                    astronauts = listOf(
                        AstronautDisplayModel(testAstronaut),
                    ),
                ),
            )
        }
    }
}
