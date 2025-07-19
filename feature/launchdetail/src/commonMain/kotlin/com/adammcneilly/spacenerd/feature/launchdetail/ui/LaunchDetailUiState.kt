package com.adammcneilly.spacenerd.feature.launchdetail.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel

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
