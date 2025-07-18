package com.adammcneilly.spacenerd.shared.app

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceTheme
import com.adammcneilly.spacenerd.core.designsystem.utils.LocalSharedTransitionScope
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.shared.di.appModules
import org.koin.compose.KoinApplication

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun App(
    appState: AppState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    KoinApplication(
        application = {
            modules(appModules)
        },
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
}
