package com.adammcneilly.spacenerd.shared.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

data class LaunchListUiState(
    val launches: List<LaunchDisplayModel>,
    val selectedLaunch: LaunchDisplayModel?,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): LaunchListUiState {
            val placeholderLaunches = List(3) {
                LaunchDisplayModel.placeholder()
            }

            return LaunchListUiState(
                launches = placeholderLaunches,
                selectedLaunch = null,
            )
        }
    }
}
