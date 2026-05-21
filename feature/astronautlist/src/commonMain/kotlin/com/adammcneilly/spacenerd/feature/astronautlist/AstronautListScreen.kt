package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
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
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchContent
import com.adammcneilly.spacenerd.feature.astronautlist.search.AstronautListSearchUiState
import org.koin.compose.viewmodel.koinViewModel

@Composable
@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Suppress("LongMethod")
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

    LaunchedEffect(sheetState.targetValue) {
        println("ADAMLOG - SHEET STATE TARGET VALUE: ${sheetState.targetValue}")
        if (sheetState.targetValue == SheetValue.Hidden) {
            println("ADAMLOG - SEARCH HIDDEN?")
            viewModel.onEvent(AstronautListUiEvent.SearchHidden)
        }
    }

    LaunchedEffect(state.value.searchVisible) {
        if (state.value.searchVisible && !sheetState.isVisible) {
            sheetState.show()
            sheetState.expand()
        } else {
            sheetState.hide()
        }
    }

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
