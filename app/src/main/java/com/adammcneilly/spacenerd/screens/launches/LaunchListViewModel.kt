package com.adammcneilly.spacenerd.screens.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest
import com.adammcneilly.spacenerd.shared.data.launch.LaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchListViewModel @Inject constructor(
    private val launchRepository: LaunchRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(LaunchListState.default())
    val state = mutableState.asStateFlow()

    init {
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

    fun onEvent(
        event: LaunchListEvent,
    ) {
        when (event) {
            is LaunchListEvent.LaunchSelected -> {
                processLaunchSelected(event)
            }
            is LaunchListEvent.NavigatedToLaunch -> {
                processNavigatedToLaunch()
            }
        }
    }

    private fun processLaunchSelected(
        event: LaunchListEvent.LaunchSelected,
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
