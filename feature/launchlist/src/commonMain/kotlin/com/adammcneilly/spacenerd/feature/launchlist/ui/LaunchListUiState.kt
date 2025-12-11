package com.adammcneilly.spacenerd.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

/**
 * Represents the UI state for the launch list screen.
 *
 * @property[launches] The list of upcoming rocket launches to display.
 * @property[selectedLaunch] The launch that is currently selected by the user, or null if none is selected.
 */
data class LaunchListUiState(
    val launches: List<LaunchDisplayModel>,
    val selectedLaunch: LaunchDisplayModel?,
    val launchWidgetSupported: Boolean,
) {
    companion object {
        fun default(
            launchWidgetSupported: Boolean = false,
        ): LaunchListUiState {
            val placeholderLaunches = List(3) {
                LaunchDisplayModel.placeholder()
            }

            return LaunchListUiState(
                launches = placeholderLaunches,
                selectedLaunch = null,
                launchWidgetSupported = launchWidgetSupported,
            )
        }
    }
}
