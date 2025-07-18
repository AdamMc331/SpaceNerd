package com.adammcneilly.spacenerd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import com.adammcneilly.spacenerd.core.designsystem.utils.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.HomeTab
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListScreen
import com.adammcneilly.spacenerd.feature.stationlist.StationListScreen
import com.adammcneilly.spacenerd.shared.feature.launchdetail.LaunchDetailScreen
import com.adammcneilly.spacenerd.shared.feature.launchlist.LaunchListScreen
import com.adammcneilly.spacenerd.shared.feature.news.NewsScreen

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
            when (key) {
                is AppScreen.LaunchDetail -> {
                    launchDetailEntry(key)
                }

                is AppScreen.Tab -> {
                    homeTabEntry(
                        key = key,
                        backStack = backStack,
                    )
                }
            }
        },
    )
}

private fun launchDetailEntry(
    key: AppScreen.LaunchDetail,
): NavEntry<AppScreen> {
    return NavEntry(
        key = key,
        metadata = TwoPaneScene.twoPane(),
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
        ) {
            LaunchDetailScreen(
                launchId = key.launchId,
            )
        }
    }
}

private fun homeTabEntry(
    key: AppScreen.Tab,
    backStack: SnapshotStateList<AppScreen>,
): NavEntry<AppScreen> {
    val metadata = if (key.tab == HomeTab.Launches) {
        TwoPaneScene.twoPane()
    } else {
        emptyMap()
    }

    return NavEntry(
        key = key,
        metadata = metadata,
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
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
                    StationListScreen()
                }
            }
        }
    }
}
