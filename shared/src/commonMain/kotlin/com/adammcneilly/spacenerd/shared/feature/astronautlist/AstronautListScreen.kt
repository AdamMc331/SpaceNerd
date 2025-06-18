package com.adammcneilly.spacenerd.shared.feature.astronautlist

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
fun AstronautListScreen(
    modifier: Modifier = Modifier,
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Astronauts",
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
