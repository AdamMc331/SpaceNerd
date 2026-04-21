package com.adammcneilly.spacenerd.feature.astronautlist

import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel

data class AstronautListUiState(
    val astronauts: List<AstronautDisplayModel>,
    val selectedAstronaut: AstronautDisplayModel?,
) {
    companion object {
        fun default(): AstronautListUiState {
            return AstronautListUiState(
                astronauts = List(3) {
                    AstronautDisplayModel.placeholder()
                },
                selectedAstronaut = null,
            )
        }
    }
}
