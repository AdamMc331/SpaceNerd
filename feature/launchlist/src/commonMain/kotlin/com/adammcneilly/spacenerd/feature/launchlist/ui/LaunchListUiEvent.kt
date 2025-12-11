package com.adammcneilly.spacenerd.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

/**
 * Defines all UI events that can be triggered on the launch list screen.
 */
sealed interface LaunchListUiEvent {
    /**
     * Triggered when the user clicks on a specific [launch].
     */
    data class LaunchSelected(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent

    /**
     * Triggered when the user navigates to a specific [launch].
     */
    data class NavigatedToLaunch(
        val launch: LaunchDisplayModel,
    ) : LaunchListUiEvent

    /**
     * Triggered when the user clicks the button to pin the widget to their home screen.
     */
    data object PinWidgetClicked : LaunchListUiEvent
}
