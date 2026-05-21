package com.adammcneilly.spacenerd.test.paparazzi.feature.astronautlist.search

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
            AstronautListSearchContent(state)
        }
    }

    @Test
    fun renderAllFieldsSelected() {
        val state = AstronautListSearchUiState(
            inSpace = true,
        )

        snapshot {
            AstronautListSearchContent(state)
        }
    }

    @Test
    fun renderNoFieldsSelected() {
        val state = AstronautListSearchUiState(
            inSpace = false,
        )

        snapshot {
            AstronautListSearchContent(state)
        }
    }
}
