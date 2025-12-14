package com.adammcneilly.spacenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.saveable.rememberSaveable
import com.adammcneilly.spacenerd.core.deeplinks.DeepLink
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.navigation.AppNavHost
import com.adammcneilly.spacenerd.shared.app.App
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main entry point of the Android application, launched when the user clicks on the
 * app icon.
 */
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
                AppNavHost(
                    deepLink = getDeepLink(),
                )
            }
        }
    }

    private fun getDeepLink(): DeepLink? {
        val launchId = intent?.extras?.getString("launchId")

        return when {
            (launchId != null) -> {
                DeepLink.LaunchDetail(launchId)
            }

            else -> {
                null
            }
        }
    }
}
