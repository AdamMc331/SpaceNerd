package com.adammcneilly.spacenerd.feature.astronautlist

import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel

sealed interface AstronautListUiEvent {
    data class AstronautSelected(
        val astronaut: AstronautDisplayModel,
    ) : AstronautListUiEvent

    data class NavigatedToAstronaut(
        val astronaut: AstronautDisplayModel,
    ) : AstronautListUiEvent

    data object SearchClicked : AstronautListUiEvent

    data object SearchHidden : AstronautListUiEvent

    sealed interface SearchEvent : AstronautListUiEvent {
        data object InSpaceClicked : SearchEvent
    }
}
