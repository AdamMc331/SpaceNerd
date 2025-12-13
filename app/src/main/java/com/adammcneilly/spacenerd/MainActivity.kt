package com.adammcneilly.spacenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.setWidgetPreviews
import androidx.lifecycle.lifecycleScope
import com.adammcneilly.spacenerd.android.widget.NextLaunchWidgetReceiver
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.navigation.AppNavHost
import com.adammcneilly.spacenerd.shared.app.App
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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

        val launchId = intent?.extras?.getString("launchId")

        setContent {
            enableEdgeToEdge()

            val appState = rememberSaveable(saver = AppState.saver) {
                AppState()
            }

            App(
                appState = appState,
            ) {
                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        GlanceAppWidgetManager(this@MainActivity).setWidgetPreviews<NextLaunchWidgetReceiver>()
                    }
                }

                AppNavHost(
                    launchId = launchId,
                )
            }
        }
    }
}
