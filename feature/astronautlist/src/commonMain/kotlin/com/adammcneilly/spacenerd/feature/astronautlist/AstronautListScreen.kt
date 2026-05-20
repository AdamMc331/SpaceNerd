package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.PersistentToast
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import org.koin.compose.viewmodel.koinViewModel

@Composable
@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
fun AstronautListScreen(
    navigateToAstronaut: (AstronautDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AstronautListViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()

    val selectedAstronaut = state.value.selectedAstronaut

    LaunchedEffect(selectedAstronaut) {
        if (selectedAstronaut != null) {
            navigateToAstronaut.invoke(selectedAstronaut)
            viewModel.onEvent(AstronautListUiEvent.NavigatedToAstronaut(selectedAstronaut))
        }
    }

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        navigationBar = {
            PersistentNavigationBar()
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        toastMessage = {
            val message = when (state.value.syncStatus) {
                SyncStatus.Initial, SyncStatus.Refresh -> "Refreshing astronaut list..."
                else -> null
            }

            PersistentToast(
                message = message,
            )
        },
        content = { scaffoldPadding ->
            AstronautListContent(
                state = state.value,
                onEvent = viewModel::onEvent,
                modifier = Modifier
                    .padding(scaffoldPadding),
            )
        },
    )
}
