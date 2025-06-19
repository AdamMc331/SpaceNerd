package com.adammcneilly.spacenerd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import com.adammcneilly.spacenerd.shared.app.LocalAppState
import com.adammcneilly.spacenerd.shared.feature.astronautlist.AstronautListScreen
import com.adammcneilly.spacenerd.shared.feature.launchdetail.LaunchDetailScreen
import com.adammcneilly.spacenerd.shared.feature.launchlist.LaunchListScreen
import com.adammcneilly.spacenerd.shared.feature.news.NewsScreen
import com.adammcneilly.spacenerd.shared.feature.stationslist.StationsListScreen
import com.adammcneilly.spacenerd.shared.navigation.HomeTab
import com.adammcneilly.spacenerd.shared.scaffold.LocalNavAnimatedVisibilityScope

@Composable
fun AppNavHost() {
    val startDestination = AppScreen.Tab(HomeTab.News)

    val backStack = rememberNavBackStack<AppScreen>(
        startDestination,
    )

    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(currentTab) {
        if (currentTab != null) {
            val previousTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (previousTab != null) {
                if (currentTab != previousTab) {
                    // Before adding this tab, drop everything up to the first tab
                    while (backStack.lastOrNull() != startDestination) {
                        backStack.removeLastOrNull()
                    }

                    // Need to navigate to current tab
                    backStack.add(AppScreen.Tab(currentTab))
                }
            }
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()

            // If we're navigating back to a home tab, update app state.
            val newTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (newTab != null) {
                appState.onNavItemSelected(newTab)
            }
        },
        sceneStrategy = TwoPaneSceneStrategy(),
        entryProvider = { key ->
            NavEntry(
                key = key,
                metadata = TwoPaneScene.twoPane(),
            ) {
                CompositionLocalProvider(
                    LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
                ) {
                    when (key) {
                        is AppScreen.LaunchDetail -> {
                            LaunchDetailScreen(
                                launchId = key.launchId,
                            )
                        }

                        is AppScreen.Tab -> {
                            RenderHomeTab(
                                key = key,
                                backStack = backStack,
                            )
                        }
                    }
                }
            }
        },
    )
}

@Composable
private fun RenderHomeTab(
    key: AppScreen.Tab,
    backStack: SnapshotStateList<AppScreen>,
) {
    when (key.tab) {
        HomeTab.News -> {
            NewsScreen()
        }

        HomeTab.Launches -> {
            LaunchListScreen(
                navigateToLaunch = { launch ->
                    val newScreen = AppScreen.LaunchDetail(launch.id)

                    if (backStack.lastOrNull() is AppScreen.LaunchDetail) {
                        backStack[backStack.lastIndex] = newScreen
                    } else {
                        backStack.add(newScreen)
                    }
                },
            )
        }

        HomeTab.Astronauts -> {
            AstronautListScreen()
        }

        HomeTab.Stations -> {
            StationsListScreen()
        }
    }
}
