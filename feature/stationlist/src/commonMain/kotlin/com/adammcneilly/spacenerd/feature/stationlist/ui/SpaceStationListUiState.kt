package com.adammcneilly.spacenerd.feature.stationlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

data class SpaceStationListUiState(
    val stations: List<SpaceStationDisplayModel>,
    val selectedStation: SpaceStationDisplayModel?,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): SpaceStationListUiState {
            val placeholderStations = List(3) {
                SpaceStationDisplayModel.placeholder()
            }

            return SpaceStationListUiState(
                stations = placeholderStations,
                selectedStation = null,
            )
        }
    }
}
