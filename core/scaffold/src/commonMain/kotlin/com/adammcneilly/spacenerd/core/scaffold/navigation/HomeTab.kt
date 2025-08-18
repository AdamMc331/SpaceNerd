package com.adammcneilly.spacenerd.core.scaffold.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Defines a tab that will be shown on the home screen in a navigation container.
 */
enum class HomeTab(
    val label: String,
    val icon: ImageVector,
) {
    News(
        label = "News",
        icon = Icons.Default.Newspaper,
    ),
    Launches(
        label = "Launches",
        icon = Icons.Default.RocketLaunch,
    ),
    Astronauts(
        label = "Astronauts",
        icon = Icons.Default.Groups,
    ),
    Stations(
        label = "Stations",
        icon = Icons.Default.SatelliteAlt,
    ),
}
