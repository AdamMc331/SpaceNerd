package com.adammcneilly.spacenerd.shared.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun SpaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = rememberDynamicColorScheme(
        seedColor = SpaceNerdColors.SeedColor,
        isDark = darkTheme,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = getTypography(),
        shapes = Shapes,
        content = content,
    )
}
