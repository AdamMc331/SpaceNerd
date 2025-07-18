package com.adammcneilly.spacenerd.shared.feature.launchdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.shared.feature.launchdetail.ui.LaunchDetailContent
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun LaunchDetailScreen(
    launchId: String,
    modifier: Modifier = Modifier,
    viewModel: LaunchDetailViewModel = koinViewModel(
        key = "LaunchDetailVm_$launchId",
        parameters = {
            parametersOf(launchId)
        },
    ),
) {
    val state = viewModel.state.collectAsState()

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        content = { scaffoldPadding ->
            LaunchDetailContent(
                state = state.value,
                contentPadding = scaffoldPadding,
            )
        },
    )
}
