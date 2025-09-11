package com.adammcneilly.spacenerd.feature.astronautdetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AstronautDetailViewModel(
    val astronautId: String,
) : ViewModel() {
    private val mutableState = MutableStateFlow(AstronautDetailUiState.default())
    val state = mutableState.asStateFlow()
}
