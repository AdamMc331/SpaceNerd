package com.adammcneilly.spacenerd.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus

/**
 * Represents the UI state for the launch list screen.
 *
 * @property[launches] The list of upcoming rocket launches to display. May be overriden
 * to show loading states via [displayLaunches].
 * @property[selectedLaunch] The launch that is currently selected by the user, or null if none is selected.
 */
data class LaunchListUiState(
    private val launches: List<LaunchDisplayModel>,
    val selectedLaunch: LaunchDisplayModel?,
    val launchWidgetSupported: Boolean,
    val syncStatus: SyncStatus,
) {
    /**
     * If we're syncing data for the initial time of running the app,
     * we can override and display a few loading launches instead of
     * the empty list from our local data source.
     */
    val displayLaunches = when (syncStatus) {
        SyncStatus.Initial -> {
            List(3) {
                LaunchDisplayModel.placeholder()
            }
        }
        else -> {
            launches
        }
    }

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
                syncStatus = SyncStatus.None,
            )
        }
    }
}
