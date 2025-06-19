package com.adammcneilly.spacenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.saveable.rememberSaveable
import com.adammcneilly.spacenerd.navigation.AppNavHost
import com.adammcneilly.spacenerd.shared.app.App
import com.adammcneilly.spacenerd.shared.app.AppState
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
                AppState()
            }

            App(
                appState = appState,
            ) {
                AppNavHost()
            }
        }
    }
}
