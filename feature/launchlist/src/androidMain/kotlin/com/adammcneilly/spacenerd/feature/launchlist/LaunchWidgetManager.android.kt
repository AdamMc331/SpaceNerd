package com.adammcneilly.spacenerd.feature.launchlist

import android.content.Context
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.GlanceAppWidgetManager
import com.adammcneilly.spacenerd.android.widget.NextLaunchWidget
import com.adammcneilly.spacenerd.android.widget.NextLaunchWidgetReceiver

class AndroidLaunchWidgetManager(
    private val context: Context,
) : LaunchWidgetManager {
    override fun launchWidgetSupported(): Boolean {
        return true
    }

    override suspend fun requestPinWidget(): Boolean {
        return GlanceAppWidgetManager(context).requestPinGlanceAppWidget(
            receiver = NextLaunchWidgetReceiver::class.java,
            preview = NextLaunchWidget(),
            previewState = DpSize(250.dp, 100.dp),
        )
    }
}
