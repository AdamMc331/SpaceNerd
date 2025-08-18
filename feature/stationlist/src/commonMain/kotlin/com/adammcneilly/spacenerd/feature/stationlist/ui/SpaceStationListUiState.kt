package com.adammcneilly.spacenerd.feature.stationlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

/**
 * Defines a user friendly representation of the information to display
 * on the space station list screen.
 */
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
