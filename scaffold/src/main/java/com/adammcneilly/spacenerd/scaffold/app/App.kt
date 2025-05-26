package com.adammcneilly.spacenerd.scaffold.app

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.scaffold.LocalSharedTransitionScope
import com.adammcneilly.spacenerd.scaffold.ui.theme.SpaceTheme

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun App(
    appState: AppState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    SpaceTheme {
        Surface {
            SharedTransitionLayout(
                modifier = modifier
                    .fillMaxSize(),
            ) {
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this,
                    LocalAppState provides appState,
                ) {
                    content()
                }
            }
        }
    }
}
