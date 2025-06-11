package com.adammcneilly.spacenerd.shared.ui.utils

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
expect fun currentWindowSizeClass(): WindowSizeClass

@Composable
fun currentWindowHeightSizeClass(): WindowHeightSizeClass {
    return currentWindowSizeClass().heightSizeClass
}

@Composable
fun currentWindowWidthSizeClass(): WindowWidthSizeClass {
    return currentWindowSizeClass().widthSizeClass
}
