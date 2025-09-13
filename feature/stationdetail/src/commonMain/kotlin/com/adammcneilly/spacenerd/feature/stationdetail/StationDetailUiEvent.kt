package com.adammcneilly.spacenerd.feature.stationdetail

import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel

/**
 * Defines all UI events that can be triggered on the station list screen.
 */
sealed interface StationDetailUiEvent {
    /**
     * Triggered when the user clicks on a specific [crewMember].
     */
    data class CrewMemberSelected(
        val crewMember: CrewMemberDisplayModel,
    ) : StationDetailUiEvent

    /**
     * Triggered when the user navigates to a specific [crewMember].
     */
    data class NavigatedToCrewMember(
        val crewMember: CrewMemberDisplayModel,
    ) : StationDetailUiEvent
}
