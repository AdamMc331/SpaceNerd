package com.adammcneilly.spacenerd.screens.launchdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun LaunchDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: LaunchDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        content = { scaffoldPadding ->
            LaunchDetailContent(
                state = state.value,
            )
        },
    )
}
