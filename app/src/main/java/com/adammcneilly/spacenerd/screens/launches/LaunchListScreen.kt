package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun LaunchListScreen(
    modifier: Modifier = Modifier,
    viewModel: LaunchListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        navigationBar = {
            PersistentNavigationBar()
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        content = { scaffoldPadding ->
            LaunchListContent(
                state = state.value,
                contentPadding = scaffoldPadding,
            )
        },
    )
}
