package com.adammcneilly.spacenerd.feature.stationlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

sealed interface SpaceStationListUiEvent {
    data class StationSelected(
        val station: SpaceStationDisplayModel,
    ) : SpaceStationListUiEvent

    data class NavigatedToStation(
        val station: SpaceStationDisplayModel,
    ) : SpaceStationListUiEvent
}
