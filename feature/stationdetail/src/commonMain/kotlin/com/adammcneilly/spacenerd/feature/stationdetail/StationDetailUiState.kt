package com.adammcneilly.spacenerd.feature.stationdetail

import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

/**
 * This is a user friendly representation of all of the data to be displayed
 * on the station detail screen.
 */
data class StationDetailUiState(
    val station: SpaceStationDisplayModel,
    val crew: List<CrewMemberDisplayModel>,
) {
    companion object {
        fun default(): StationDetailUiState {
            return StationDetailUiState(
                station = SpaceStationDisplayModel.placeholder(),
                crew = List(3) {
                    CrewMemberDisplayModel.placeholder()
                },
            )
        }
    }
}
