package com.adammcneilly.spacenerd.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(
    val route: String,
    val labelRes: Int,
    val icon: ImageVector,
) {
    News(
        route = "news",
        labelRes = R.string.news,
        icon = Icons.Default.Newspaper,
    ),
    Launches(
        route = "launches",
        labelRes = R.string.launches,
        icon = Icons.Default.RocketLaunch,
    ),
    Astronauts(
        route = "astronauts",
        labelRes = R.string.astronauts,
        icon = Icons.Default.Groups,
    ),
    Stations(
        route = "stations",
        labelRes = R.string.stations,
        icon = Icons.Default.SatelliteAlt,
    ),
}
