package com.adammcneilly.spacenerd.shared.ui.utils

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
actual fun currentWindowSizeClass(): WindowSizeClass {
    return calculateWindowSizeClass(
        activity = (LocalContext.current as Activity),
    )
}
