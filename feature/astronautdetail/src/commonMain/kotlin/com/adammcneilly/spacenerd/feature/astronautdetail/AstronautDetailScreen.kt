package com.adammcneilly.spacenerd.feature.astronautdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun AstronautDetailScreen(
    astronautId: String,
    modifier: Modifier = Modifier,
    viewModel: AstronautDetailViewModel = koinViewModel(
        key = "AstronautDetailVm_$astronautId",
        parameters = {
            parametersOf(astronautId)
        },
    ),
) {
    val state = viewModel.state.collectAsState()

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        content = { scaffoldPadding ->
            AstronautDetailContent(
                state = state.value,
                contentPadding = scaffoldPadding,
                modifier = modifier,
            )
        },
    )
}
