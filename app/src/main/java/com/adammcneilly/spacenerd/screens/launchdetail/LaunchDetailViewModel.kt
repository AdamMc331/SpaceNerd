package com.adammcneilly.spacenerd.screens.launchdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchDetailViewModel @Inject constructor(
    private val launchRepository: LaunchRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(LaunchDetailState.default())
    val state = mutableState.asStateFlow()

    fun observeLaunch(
        launchId: String,
    ) {
        viewModelScope.launch {
            launchRepository.getLaunch(launchId)
                .collect { launch ->
                    val displayModel = LaunchDisplayModel(launch)

                    mutableState.update { currentState ->
                        currentState.copy(
                            launch = displayModel,
                        )
                    }
                }
        }
    }
}
