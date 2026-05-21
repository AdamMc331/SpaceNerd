package com.adammcneilly.spacenerd.test.paparazzi.feature.astronautlist.search

import androidx.compose.ui.state.ToggleableState
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListContent
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchContent
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test

class AstronautListSearchContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        val state = AstronautListSearchUiState.default()

        snapshot {
            AstronautListSearchContent(
                state = state,
                onEvent = {},
            )
        }
    }

    @Test
    fun renderAllFieldsSelected() {
        val state = AstronautListSearchUiState(
            inSpace = ToggleableState.On,
        )

        snapshot {
            AstronautListSearchContent(
                state = state,
                onEvent = {},
            )
        }
    }

    @Test
    fun renderNoFieldsSelected() {
        val state = AstronautListSearchUiState(
            inSpace = ToggleableState.Off,
        )

        snapshot {
            AstronautListSearchContent(
                state = state,
                onEvent = {},
            )
        }
    }
}
