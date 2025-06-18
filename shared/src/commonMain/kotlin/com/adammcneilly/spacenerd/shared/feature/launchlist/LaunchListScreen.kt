package com.adammcneilly.spacenerd.shared.feature.launchlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.feature.launchlist.ui.LaunchListContent
import com.adammcneilly.spacenerd.shared.feature.launchlist.ui.LaunchListUiEvent
import com.adammcneilly.spacenerd.shared.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.shared.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.shared.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.shared.scaffold.rememberScaffoldState
import org.koin.compose.viewmodel.koinViewModel

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun LaunchListScreen(
    navigateToLaunch: (LaunchDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LaunchListViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()
    val selectedLaunch = state.value.selectedLaunch

    LaunchedEffect(selectedLaunch) {
        if (selectedLaunch != null) {
            navigateToLaunch.invoke(selectedLaunch)
            viewModel.onEvent(LaunchListUiEvent.NavigatedToLaunch(selectedLaunch))
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
