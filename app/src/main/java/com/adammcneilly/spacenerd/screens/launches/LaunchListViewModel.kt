package com.adammcneilly.spacenerd.screens.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
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
    private val launchRepository: LaunchRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(LaunchListState.default())
    val state = mutableState.asStateFlow()

    init {
        observeLaunches()
    }

    private fun observeLaunches() {
        val launchRequest = LaunchListRequest(
            after = Clock.System.now(),
            before = Clock.System.now().plus(30.days),
        )

        viewModelScope.launch {
            launchRepository
                .getLaunches(launchRequest)
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
}
