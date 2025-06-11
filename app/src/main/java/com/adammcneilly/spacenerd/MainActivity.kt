package com.adammcneilly.spacenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
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

            val appState = remember {
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
