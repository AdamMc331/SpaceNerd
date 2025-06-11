package com.adammcneilly.spacenerd.screens.stations

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.shared.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.shared.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.shared.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.shared.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
fun StationsListScreen(
    modifier: Modifier = Modifier,
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Stations",
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
                text = "Stations List Screen",
                modifier = Modifier
                    .padding(scaffoldPadding),
            )
        },
    )
}
