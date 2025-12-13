package com.adammcneilly.spacenerd.feature.launchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.feature.launchlist.ui.LaunchListUiEvent
import com.adammcneilly.spacenerd.feature.launchlist.ui.LaunchListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the state management container for the launch list screen. It requests launches
 * from the [launchRepository] and exposes the information via the [state] Flow.
 */
class LaunchListViewModel(
    private val launchRepository: LaunchRepository,
    private val launchWidgetManager: LaunchWidgetManager,
) : ViewModel() {
    private val mutableState = MutableStateFlow(
        LaunchListUiState.default(
            launchWidgetSupported = launchWidgetManager.launchWidgetSupported(),
        ),
    )
    val state = mutableState.asStateFlow()

    init {
        observeSyncStatus()
        observeLaunches()
    }

    private fun observeLaunches() {
        viewModelScope.launch {
            launchRepository
                .getLaunches(LaunchListRequest.Upcoming)
                .collectLatest { launches ->
                    val displayModels = launches.map(::LaunchDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            launches = displayModels,
                        )
                    }
                }
        }
    }

    private fun observeSyncStatus() {
        viewModelScope.launch {
            launchRepository.syncStatus
                .collectLatest { syncStatus ->
                    mutableState.update { currentState ->
                        currentState.copy(
                            syncStatus = syncStatus,
                        )
                    }
                }
        }
    }

    fun onEvent(
        event: LaunchListUiEvent,
    ) {
        when (event) {
            is LaunchListUiEvent.LaunchSelected -> {
                processLaunchSelected(event)
            }

            is LaunchListUiEvent.NavigatedToLaunch -> {
                processNavigatedToLaunch()
            }

            is LaunchListUiEvent.PinWidgetClicked -> {
                processPinWidgetClicked()
            }
        }
    }

    private fun processPinWidgetClicked() {
        viewModelScope.launch {
            launchWidgetManager.requestPinWidget()
        }
    }

    private fun processLaunchSelected(
        event: LaunchListUiEvent.LaunchSelected,
    ) {
        mutableState.update { currentState ->
            currentState.copy(
                selectedLaunch = event.launch,
            )
        }
    }

    private fun processNavigatedToLaunch() {
        mutableState.update { currentState ->
            currentState.copy(
                selectedLaunch = null,
            )
        }
    }
}
