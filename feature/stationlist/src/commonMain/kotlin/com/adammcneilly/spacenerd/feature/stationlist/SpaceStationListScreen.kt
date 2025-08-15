package com.adammcneilly.spacenerd.feature.stationlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.designsystem.utils.LocalSceneType
import com.adammcneilly.spacenerd.core.designsystem.utils.SceneType
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListContent
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListUiEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun SpaceStationListScreen(
    navigateToStation: (SpaceStationDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SpaceStationListViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()
    val selectedStation = state.value.selectedStation

    LaunchedEffect(selectedStation) {
        if (selectedStation != null) {
            navigateToStation.invoke(selectedStation)
            viewModel.onEvent(SpaceStationListUiEvent.NavigatedToStation(selectedStation))
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
            if (LocalSceneType.current != SceneType.TwoPane) {
                PersistentNavigationRail()
            }
        },
        content = { scaffoldPadding ->
            SpaceStationListContent(
                state = state.value,
                contentPadding = scaffoldPadding,
                onEvent = viewModel::onEvent,
            )
        },
    )
}
