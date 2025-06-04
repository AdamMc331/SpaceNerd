package com.adammcneilly.spacenerd.core.ui.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    News(
        route = "news",
        label = "News",
        icon = Icons.Default.Newspaper,
    ),
    Launches(
        route = "launches",
        label = "Launches",
        icon = Icons.Default.RocketLaunch,
    ),
    Astronauts(
        route = "astronauts",
        label = "Astronauts",
        icon = Icons.Default.Groups,
    ),
    Stations(
        route = "stations",
        label = "Stations",
        icon = Icons.Default.SatelliteAlt,
    ),
}
