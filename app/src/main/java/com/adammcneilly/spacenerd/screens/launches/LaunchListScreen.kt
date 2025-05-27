package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.scaffold.R as scaffoldR

@Composable
@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
fun LaunchListScreen(
    modifier: Modifier = Modifier,
    viewModel: LaunchListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(scaffoldR.string.launches),
                    )
                },
            )
        },
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
