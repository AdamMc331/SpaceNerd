package com.adammcneilly.spacenerd.core.designsystem.utils

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
actual fun currentWindowSizeClass(): WindowSizeClass {
    return calculateWindowSizeClass()
}
