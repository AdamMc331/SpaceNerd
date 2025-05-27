package com.adammcneilly.spacenerd.screens.astronauts

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun AstronautListScreen(
    modifier: Modifier = Modifier,
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
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
