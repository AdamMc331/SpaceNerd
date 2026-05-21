package com.adammcneilly.spacenerd.feature.astronautlist.search

import androidx.compose.ui.state.ToggleableState

data class AstronautListSearchUiState(
    val inSpace: ToggleableState,
) {
    companion object {
        fun default(): AstronautListSearchUiState {
            return AstronautListSearchUiState(
                inSpace = ToggleableState.Indeterminate,
            )
        }
    }
}
