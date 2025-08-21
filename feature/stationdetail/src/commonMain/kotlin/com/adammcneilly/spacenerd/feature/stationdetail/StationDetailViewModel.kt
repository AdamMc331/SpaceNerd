package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StationDetailViewModel(
    private val stationId: String,
    private val stationRepository: SpaceStationRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(StationDetailUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeStation()
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
