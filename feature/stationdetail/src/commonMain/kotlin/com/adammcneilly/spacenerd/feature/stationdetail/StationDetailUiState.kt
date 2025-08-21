package com.adammcneilly.spacenerd.feature.stationdetail

import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

/**
 * This is a user friendly representation of all of the data to be displayed
 * on the station detail screen.
 */
data class StationDetailUiState(
    val station: SpaceStationDisplayModel,
) {
    companion object {
        fun default(): StationDetailUiState {
            return StationDetailUiState(
                station = SpaceStationDisplayModel.placeholder(),
            )
        }
    }
}
