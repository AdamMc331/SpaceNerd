package com.adammcneilly.spacenerd.feature.stationdetail

import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

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
