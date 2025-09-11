package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionRepository
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the state management container for the station detail screen. It will request data
 * from the [stationRepository] for the supplied [stationId].
 */
class StationDetailViewModel(
    private val stationId: String,
    private val stationRepository: SpaceStationRepository,
    private val expeditionRepository: ExpeditionRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(StationDetailUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeStation()
        observeCrew()
    }

    fun onEvent(
        uiEvent: StationDetailUiEvent,
    ) {
        when (uiEvent) {
            is StationDetailUiEvent.CrewMemberSelected -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedCrewMember = uiEvent.crewMember,
                    )
                }
            }
            is StationDetailUiEvent.NavigatedToCrewMember -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedCrewMember = null,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeCrew() {
        viewModelScope.launch {
            val request = ExpeditionListRequest(
                spaceStationId = stationId,
                isActive = true,
            )

            expeditionRepository.getExpeditions(request)
                .map { expeditions ->
                    expeditions.flatMap(Expedition::crew)
                }
                .collect { crew ->
                    val displayModels = crew.map(::CrewMemberDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            crew = displayModels,
                        )
                    }
                }
        }
    }

    private fun observeStation() {
        viewModelScope.launch {
            stationRepository
                .getStation(stationId)
                .collect { station ->
                    val displayModel = SpaceStationDisplayModel(station)

                    mutableState.update { currentState ->
                        currentState.copy(
                            station = displayModel,
                        )
                    }
                }
        }
    }
}
