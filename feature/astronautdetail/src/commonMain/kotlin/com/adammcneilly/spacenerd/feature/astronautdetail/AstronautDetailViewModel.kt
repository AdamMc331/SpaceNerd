package com.adammcneilly.spacenerd.feature.astronautdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AstronautDetailViewModel(
    val astronautId: String,
    val astronautRepository: AstronautRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(AstronautDetailUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeAstronaut()
    }

    private fun observeAstronaut() {
        viewModelScope.launch {
            astronautRepository.getAstronaut(astronautId)
                .collect { astronaut ->
                    mutableState.value = mutableState.value.copy(
                        astronaut = AstronautDisplayModel(astronaut),
                    )
                }
        }
    }
}
