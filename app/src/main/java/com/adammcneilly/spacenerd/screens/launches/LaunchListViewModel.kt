package com.adammcneilly.spacenerd.screens.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.domain.usecases.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.plus
import javax.inject.Inject
import kotlin.time.Duration.Companion.days

@HiltViewModel
class LaunchListViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(LaunchListState.default())
    val state = mutableState.asStateFlow()

    init {
        observeLaunches()
    }

    private fun observeLaunches() {
        viewModelScope.launch {
            getLaunchesUseCase.invoke(
                request = LaunchListRequest(
                    after = Clock.System.now(),
                    before = Clock.System.now().plus(30.days),
                ),
            )
                .collectLatest { launches ->
                    mutableState.update { currentState ->
                        currentState.copy(
                            launches = launches,
                        )
                    }
                }
        }
    }
}
