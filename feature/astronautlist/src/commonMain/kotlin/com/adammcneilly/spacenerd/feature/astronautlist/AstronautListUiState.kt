package com.adammcneilly.spacenerd.feature.astronautlist

import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus

data class AstronautListUiState(
    private val astronauts: List<AstronautDisplayModel>,
    val selectedAstronaut: AstronautDisplayModel?,
    val syncStatus: SyncStatus,
    val searchVisible: Boolean,
) {
    /**
     * If we're syncing data for the initial time of running the app,
     * we can override and display a few loading astronauts instead of
     * the empty list from our local data source.
     */
    val displayAstronauts = when (syncStatus) {
        SyncStatus.Initial -> {
            List(3) {
                AstronautDisplayModel.placeholder()
            }
        }

        else -> {
            astronauts
        }
    }

    companion object {
        fun default(): AstronautListUiState {
            return AstronautListUiState(
                astronauts = emptyList(),
                selectedAstronaut = null,
                syncStatus = SyncStatus.None,
                searchVisible = false,
            )
        }
    }
}
