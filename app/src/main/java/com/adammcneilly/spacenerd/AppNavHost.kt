package com.adammcneilly.spacenerd

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.spacenerd.scaffold.HomeTab
import com.adammcneilly.spacenerd.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.screens.astronauts.AstronautListScreen
import com.adammcneilly.spacenerd.screens.launches.LaunchListScreen
import com.adammcneilly.spacenerd.screens.news.NewsScreen
import com.adammcneilly.spacenerd.screens.stations.StationsListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(currentTab) {
        val route = currentTab?.route

        if (route != null) {
            if (navController.currentBackStackEntry?.destination?.route != route) {
                navController.navigate(route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = HomeTab.News.route,
    ) {
        animatedComposable(HomeTab.News.route) {
            NewsScreen()
        }

        animatedComposable(HomeTab.Launches.route) {
            LaunchListScreen()
        }

        animatedComposable(HomeTab.Astronauts.route) {
            AstronautListScreen()
        }

        animatedComposable(HomeTab.Stations.route) {
            StationsListScreen()
        }
    }
}

private fun NavGraphBuilder.animatedComposable(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    composable(route) { backStackEntry ->
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides this,
        ) {
            content(backStackEntry)
        }
    }
}
