package com.adammcneilly.spacenerd.feature.stationlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListUiEvent
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the state management container for the space station list screen.
 *
 * It requests a list of stations via the [spaceStationRepository] and exposes that information
 * via the [state] Flow.
 */
class SpaceStationListViewModel(
    private val spaceStationRepository: SpaceStationRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main,
) : ViewModel() {
    private val mutableState = MutableStateFlow(SpaceStationListUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeStations()
    }

    private fun observeStations() {
        val activeStationsRequest = SpaceStationListRequest(
            status = SpaceStationStatus.Active,
        )

        viewModelScope.launch(dispatcher) {
            spaceStationRepository
                .getStations(activeStationsRequest)
                .collectLatest { stations ->
                    val displayModels = stations.map(::SpaceStationDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            stations = displayModels,
                        )
                    }
                }
        }
    }

    fun onEvent(
        event: SpaceStationListUiEvent,
    ) {
        when (event) {
            is SpaceStationListUiEvent.StationSelected -> {
                processStationSelected(event)
            }
            is SpaceStationListUiEvent.NavigatedToStation -> {
                processNavigatedToStation()
            }
        }
    }

    private fun processStationSelected(
        event: SpaceStationListUiEvent.StationSelected,
    ) {
        mutableState.update { currentState ->
            currentState.copy(
                selectedStation = event.station,
            )
        }
    }

    private fun processNavigatedToStation() {
        mutableState.update { currentState ->
            currentState.copy(
                selectedStation = null,
            )
        }
    }
}
