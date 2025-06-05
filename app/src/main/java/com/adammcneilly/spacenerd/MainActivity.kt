package com.adammcneilly.spacenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.saveable.rememberSaveable
import com.adammcneilly.spacenerd.core.ui.scaffold.app.App
import com.adammcneilly.spacenerd.core.ui.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.ui.scaffold.app.AppStateData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            val appState = rememberSaveable(saver = AppState.saver) {
                AppState(
                    initialData = AppStateData(),
                )
            }

            App(
                appState = appState,
            ) {
                AppNavHost()
            }
        }
    }
}
