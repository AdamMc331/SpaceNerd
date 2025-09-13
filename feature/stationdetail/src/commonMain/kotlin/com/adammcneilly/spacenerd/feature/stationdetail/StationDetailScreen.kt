package com.adammcneilly.spacenerd.feature.stationdetail

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
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
fun StationDetailScreen(
    stationId: String,
    navigateToAstronaut: (AstronautDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StationDetailViewModel = koinViewModel(
        key = "StationDetailVm_$stationId",
        parameters = {
            parametersOf(stationId)
        },
    ),
) {
    val state = viewModel.state.collectAsState()

    val selectedCrewMember = state.value.selectedCrewMember

    LaunchedEffect(selectedCrewMember) {
        if (selectedCrewMember != null) {
            navigateToAstronaut(selectedCrewMember.astronaut)
            viewModel.onEvent(StationDetailUiEvent.NavigatedToCrewMember(selectedCrewMember))
        }
    }

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        content = { scaffoldPadding ->
            StationDetailContent(
                state = state.value,
                contentPadding = scaffoldPadding,
                onEvent = viewModel::onEvent,
            )
        },
    )
}
