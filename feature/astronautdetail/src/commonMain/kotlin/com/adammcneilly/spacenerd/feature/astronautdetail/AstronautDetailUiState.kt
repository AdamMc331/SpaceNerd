package com.adammcneilly.spacenerd.feature.astronautdetail

import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel

data class AstronautDetailUiState(
    val astronaut: AstronautDisplayModel,
) {
    companion object {
        fun default(): AstronautDetailUiState {
            return AstronautDetailUiState(
                astronaut = AstronautDisplayModel.placeholder(),
            )
        }
    }
}
