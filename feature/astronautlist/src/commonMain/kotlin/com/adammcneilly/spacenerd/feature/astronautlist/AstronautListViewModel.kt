package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AstronautListViewModel(
    private val repository: AstronautRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(AstronautListUiState.default())
    val state: StateFlow<AstronautListUiState> = mutableState.asStateFlow()

    init {
        observeSyncStatus()
        observeAstronauts()
    }

    fun onEvent(
        event: AstronautListUiEvent,
    ) {
        when (event) {
            is AstronautListUiEvent.AstronautSelected -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedAstronaut = event.astronaut,
                    )
                }
            }

            is AstronautListUiEvent.NavigatedToAstronaut -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedAstronaut = null,
                    )
                }
            }

            AstronautListUiEvent.SearchClicked -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        searchVisible = true,
                    )
                }
            }

            AstronautListUiEvent.SearchHidden -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        searchVisible = false,
                    )
                }
            }
        }
    }

    private fun observeAstronauts() {
        viewModelScope.launch {
            repository.getAstronauts(AstronautListRequest())
                .collectLatest { astronauts ->
                    val displayModels = astronauts.map(::AstronautDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            astronauts = displayModels,
                        )
                    }
                }
        }
    }

    private fun observeSyncStatus() {
        viewModelScope.launch {
            repository.syncStatus
                .collectLatest { syncStatus ->
                    mutableState.update { currentState ->
                        currentState.copy(
                            syncStatus = syncStatus,
                        )
                    }
                }
        }
    }
}
