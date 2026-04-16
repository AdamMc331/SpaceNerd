package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AstronautListViewModel(
    private val repository: AstronautRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(AstronautListUiState.default())
    val state: StateFlow<AstronautListUiState> = mutableState.asStateFlow()

    init {
        observeAstronauts()
    }

    private fun observeAstronauts() {
        viewModelScope.launch {
            repository.getAstronauts(AstronautListRequest())
                .collect { astronauts ->
                    val displayModels = astronauts.map(::AstronautDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            astronauts = displayModels,
                        )
                    }
                }
        }
    }
}
