package com.adammcneilly.spacenerd.screens.astronauts

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.scaffold.R as scaffoldR

@Composable
@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
fun AstronautListScreen(
    modifier: Modifier = Modifier,
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(scaffoldR.string.astronauts),
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
            Text(
                text = "Astronaut List Screen",
                modifier = Modifier
                    .padding(scaffoldPadding),
            )
        },
    )
}
