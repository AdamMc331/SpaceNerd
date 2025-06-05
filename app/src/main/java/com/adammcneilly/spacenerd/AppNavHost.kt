package com.adammcneilly.spacenerd

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.spacenerd.core.ui.scaffold.HomeTab
import com.adammcneilly.spacenerd.core.ui.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.core.ui.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.screens.astronauts.AstronautListScreen
import com.adammcneilly.spacenerd.screens.launchdetail.LaunchDetailScreen
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
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true // Save state of popped destinations (including ViewModel saved state)
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    // Observe NavController's back stack to update AppState on system back
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(navBackStackEntry) {
        val currentRoute = navBackStackEntry?.destination?.route
        currentRoute?.let { route ->
            // Find the HomeTab corresponding to the current route
            val tabForRoute = HomeTab.entries.find { it.route == route }
            if (tabForRoute != null && appState.currentSelectedTab != tabForRoute) {
                // This will update the visual selection in your BottomNavigationBar
                // It should NOT trigger the LaunchedEffect above if currentTabFromAppState
                // is already correct, preventing navigation loops.
                appState.onNavItemSelected(tabForRoute)
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
            LaunchListScreen(
                navigateToLaunch = { launch ->
                    navController.navigate("launch/${launch.id}")
                },
            )
        }

        animatedComposable(HomeTab.Astronauts.route) {
            AstronautListScreen()
        }

        animatedComposable(HomeTab.Stations.route) {
            StationsListScreen()
        }

        animatedComposable("launch/{launchId}") {
            LaunchDetailScreen()
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
