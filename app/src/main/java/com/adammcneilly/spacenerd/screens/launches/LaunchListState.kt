package com.adammcneilly.spacenerd.screens.launches

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.DataResult

data class LaunchListState(
    val launches: DataResult<List<LaunchDisplayModel>>,
) {
    companion object {
        fun default(): LaunchListState {
            return LaunchListState(
                launches = DataResult.Loading,
            )
        }
    }
}
