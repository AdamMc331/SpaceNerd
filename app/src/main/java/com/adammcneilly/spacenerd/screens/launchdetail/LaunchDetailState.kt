package com.adammcneilly.spacenerd.screens.launchdetail

import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel

data class LaunchDetailState(
    val launch: LaunchDisplayModel,
) {
    companion object {
        fun default(): LaunchDetailState {
            return LaunchDetailState(
                launch = LaunchDisplayModel.placeholder(),
            )
        }
    }
}
