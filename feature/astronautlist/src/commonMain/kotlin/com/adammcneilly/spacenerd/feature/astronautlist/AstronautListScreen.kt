package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.PersistentToast
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchContent
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchUiState
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

    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false,
    )

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState,
    )

    observeSheetState(sheetState, viewModel)

    observeSearchVisible(state, sheetState)

    observeSelectedAstronaut(selectedAstronaut, navigateToAstronaut, viewModel)

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
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    AstronautListSearchContent(
                        state = AstronautListSearchUiState.default(),
                    )
                },
                content = {
                    AstronautListContent(
                        state = state.value,
                        onEvent = viewModel::onEvent,
                        modifier = Modifier
                            .padding(scaffoldPadding),
                    )
                },
            )
        },
    )
}

@Composable
private fun observeSelectedAstronaut(
    selectedAstronaut: AstronautDisplayModel?,
    navigateToAstronaut: (AstronautDisplayModel) -> Unit,
    viewModel: AstronautListViewModel,
) {
    LaunchedEffect(selectedAstronaut) {
        if (selectedAstronaut != null) {
            navigateToAstronaut.invoke(selectedAstronaut)
            viewModel.onEvent(AstronautListUiEvent.NavigatedToAstronaut(selectedAstronaut))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun observeSearchVisible(
    state: State<AstronautListUiState>,
    sheetState: SheetState,
) {
    LaunchedEffect(state.value.searchVisible) {
        if (state.value.searchVisible && !sheetState.isVisible) {
            sheetState.show()
            sheetState.expand()
        } else {
            sheetState.hide()
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun observeSheetState(
    sheetState: SheetState,
    viewModel: AstronautListViewModel,
) {
    LaunchedEffect(sheetState.targetValue) {
        if (sheetState.targetValue == SheetValue.Hidden) {
            viewModel.onEvent(AstronautListUiEvent.SearchHidden)
        }
    }
}
