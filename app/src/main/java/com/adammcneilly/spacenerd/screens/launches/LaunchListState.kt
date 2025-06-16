package com.adammcneilly.spacenerd.screens.launches

import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel

data class LaunchListState(
    val launches: List<LaunchDisplayModel>,
    val selectedLaunch: LaunchDisplayModel?,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): LaunchListState {
            val placeholderLaunches = List(3) {
                LaunchDisplayModel.placeholder()
            }

            return LaunchListState(
                launches = placeholderLaunches,
                selectedLaunch = null,
            )
        }
    }
}
