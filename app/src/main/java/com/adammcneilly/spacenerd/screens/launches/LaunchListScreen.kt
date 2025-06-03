package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun LaunchListScreen(
    navigateToLaunch: (LaunchDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LaunchListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    val selectedLaunch = state.value.selectedLaunch

    LaunchedEffect(selectedLaunch) {
        if (selectedLaunch != null) {
            navigateToLaunch.invoke(selectedLaunch)
            viewModel.onEvent(LaunchListEvent.NavigatedToLaunch(selectedLaunch))
        }
    }

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        navigationBar = {
            PersistentNavigationBar(
                modifier = Modifier
                    .animateEnterExit(
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it }),
                    ),
            )
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        content = { scaffoldPadding ->
            LaunchListContent(
                state = state.value,
                contentPadding = scaffoldPadding,
                onEvent = viewModel::onEvent,
            )
        },
    )
}
