package com.adammcneilly.spacenerd.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

sealed interface LaunchListUiEvent {
    data class LaunchSelected(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent

    data class NavigatedToLaunch(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent
}
