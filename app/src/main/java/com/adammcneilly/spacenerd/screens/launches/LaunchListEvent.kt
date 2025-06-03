package com.adammcneilly.spacenerd.screens.launches

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

sealed interface LaunchListEvent {
    data class LaunchSelected(
        val launch: LaunchDisplayModel,
    ) : LaunchListEvent

    data class NavigatedToLaunch(
        val launch: LaunchDisplayModel,
    ) : LaunchListEvent
}
