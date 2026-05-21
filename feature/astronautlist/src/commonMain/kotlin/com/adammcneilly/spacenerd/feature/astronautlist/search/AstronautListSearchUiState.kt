package com.adammcneilly.spacenerd.feature.astronautlist.search

data class AstronautListSearchUiState(
    val inSpace: Boolean?,
) {
    companion object {
        fun default(): AstronautListSearchUiState {
            return AstronautListSearchUiState(
                inSpace = null,
            )
        }
    }
}
