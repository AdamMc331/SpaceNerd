@file:Suppress("MagicNumber")

package com.adammcneilly.spacenerd.shared.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object SpaceNerdColors {
    val Green = Color(0xFF4CAF50)

    // Core Palette
    val DeepSpace = Color(0xFF000428)
    val NebulaPurple = Color(0xFF9D50BB)
    val HyperdriveCyan = Color(0xFF2193b0)
    val SolarFlareGold = Color(0xFFFFD700)
    val StarWhite = Color(0xFFF5F5F5)
    val LunarSurface = Color(0xFFE0E0E0)

    // Light Theme Colors
    val LightPrimary = Color(0xFF0052D4)
    val LightOnPrimary = StarWhite
    val LightSecondary = Color(0xFF4A646C)
    val LightTertiary = Color(0xFF5A5E7D)
    val LightBackground = Color(0xFFF8F9FA)
    val LightSurface = Color(0xFFF8F9FA)
    val LightOnSurface = DeepSpace

    // Dark Theme Colors
    val DarkPrimary = NebulaPurple
    val DarkOnPrimary = StarWhite
    val DarkSecondary = HyperdriveCyan
    val DarkTertiary = SolarFlareGold
    val DarkBackground = DeepSpace
    val DarkSurface = Color(0xFF0A0F37) // Slightly lighter than background for contrast
    val DarkOnSurface = StarWhite

    val DarkColorScheme = darkColorScheme(
        primary = DarkPrimary,
        onPrimary = DarkOnPrimary,
        secondary = DarkSecondary,
        tertiary = DarkTertiary,
        background = DarkBackground,
        surface = DarkSurface,
        onBackground = DarkOnSurface,
        onSurface = DarkOnSurface,
    )

    val LightColorScheme = lightColorScheme(
        primary = LightPrimary,
        onPrimary = LightOnPrimary,
        secondary = LightSecondary,
        tertiary = LightTertiary,
        background = LightBackground,
        surface = LightSurface,
        onBackground = LightOnSurface,
        onSurface = LightOnSurface,
    )
}
