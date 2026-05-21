package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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

            AstronautListUiEvent.SearchEvent.InSpaceClicked -> {
                mutableState.update { currentState ->
                    val currentInSpace = currentState.searchUiState.inSpace
                    val nextInSpace = when (currentInSpace) {
                        ToggleableState.On -> ToggleableState.Off
                        ToggleableState.Off -> ToggleableState.Indeterminate
                        ToggleableState.Indeterminate -> ToggleableState.On
                    }

                    val nextSearchUiState = currentState.searchUiState.copy(
                        inSpace = nextInSpace,
                    )

                    currentState.copy(
                        searchUiState = nextSearchUiState,
                    )
                }
            }

            AstronautListUiEvent.SearchEvent.SubmitSearch -> {
                mutableState.update { currentState ->
                    val newRequest = with(currentState.searchUiState) {
                        AstronautListRequest(
                            inSpace = this.inSpace.toBoolean(),
                        )
                    }

                    currentState.copy(
                        request = newRequest,
                        searchVisible = false,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeAstronauts() {
        viewModelScope.launch {
            state
                .map { astronautListUiState ->
                    astronautListUiState.request
                }
                .distinctUntilChanged()
                .flatMapLatest { request ->
                    repository.getAstronauts(request)
                }
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

private fun ToggleableState.toBoolean(): Boolean? {
    return when (this) {
        ToggleableState.On -> true
        ToggleableState.Off -> false
        ToggleableState.Indeterminate -> null
    }
}
