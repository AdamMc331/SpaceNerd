package com.adammcneilly.spacenerd.feature.launchdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone

/**
 * This is the state management container for the launch detail screen. It shows detailed
 * information about the given [launchId], requesting data from the supplied [launchRepository] and
 * exposing that information via the [state] Flow.
 */
class LaunchDetailViewModel(
    private val launchId: String,
    private val launchRepository: LaunchRepository,
    private val timeZone: TimeZone,
) : ViewModel() {
    private val mutableState = MutableStateFlow(LaunchDetailUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeLaunch()
    }

    private fun observeLaunch() {
        viewModelScope.launch {
            launchRepository.getLaunch(launchId)
                .collect { launch ->
                    val displayModel = LaunchDisplayModel(
                        launch = launch,
                        timeZone = timeZone,
                    )

                    mutableState.update { currentState ->
                        currentState.copy(
                            launch = displayModel,
                        )
                    }
                }
        }
    }
}
