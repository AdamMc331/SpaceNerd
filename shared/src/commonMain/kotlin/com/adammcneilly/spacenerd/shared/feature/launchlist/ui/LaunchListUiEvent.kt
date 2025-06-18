package com.adammcneilly.spacenerd.shared.feature.launchlist.ui

import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel

sealed interface LaunchListUiEvent {
    data class LaunchSelected(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent

    data class NavigatedToLaunch(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent
}
