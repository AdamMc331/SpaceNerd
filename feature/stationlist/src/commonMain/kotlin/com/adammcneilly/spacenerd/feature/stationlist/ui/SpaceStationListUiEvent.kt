package com.adammcneilly.spacenerd.feature.stationlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

/**
 * Defines all UI events that can be triggered on the space station list screen.
 */
sealed interface SpaceStationListUiEvent {
    /**
     * Triggered when a user clicks on a specific [station].
     */
    data class StationSelected(
        val station: SpaceStationDisplayModel,
    ) : SpaceStationListUiEvent

    /**
     * Triggered when a user navigates to a specific [station].
     */
    data class NavigatedToStation(
        val station: SpaceStationDisplayModel,
    ) : SpaceStationListUiEvent
}
