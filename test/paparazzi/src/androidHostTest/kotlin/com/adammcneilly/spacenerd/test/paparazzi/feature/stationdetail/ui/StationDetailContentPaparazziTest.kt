package com.adammcneilly.spacenerd.test.paparazzi.feature.stationdetail.ui

import androidx.compose.foundation.layout.PaddingValues
import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testCrewMember
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailContent
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import org.junit.Test
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
                onEvent = {},
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
                    selectedCrewMember = null,
                    crew = listOf(
                        CrewMemberDisplayModel(testCrewMember),
                        CrewMemberDisplayModel(testCrewMember),
                        CrewMemberDisplayModel(testCrewMember),
                    ),
                ),
                contentPadding = PaddingValues(),
                onEvent = {},
            )
        }
    }
}
