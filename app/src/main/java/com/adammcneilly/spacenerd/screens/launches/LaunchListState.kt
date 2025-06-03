package com.adammcneilly.spacenerd.screens.launches

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

data class LaunchListState(
    val launches: List<LaunchDisplayModel>,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): LaunchListState {
            val placeholderLaunches = List(3) {
                LaunchDisplayModel.placeholder()
            }

            return LaunchListState(
                launches = placeholderLaunches,
            )
        }
    }
}
