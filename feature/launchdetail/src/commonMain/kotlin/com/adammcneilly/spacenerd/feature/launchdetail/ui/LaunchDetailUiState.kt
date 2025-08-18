package com.adammcneilly.spacenerd.feature.launchdetail.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

/**
 * Defines the user friendly representation of the information to show on the launch detail screen.
 */
data class LaunchDetailUiState(
    val launch: LaunchDisplayModel,
) {
    companion object {
        fun default(): LaunchDetailUiState {
            return LaunchDetailUiState(
                launch = LaunchDisplayModel.placeholder(),
            )
        }
    }
}
