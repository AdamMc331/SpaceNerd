package com.adammcneilly.spacenerd.navigation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.HomeTab
import com.adammcneilly.spacenerd.feature.astronautdetail.AstronautDetailScreen
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListScreen
import com.adammcneilly.spacenerd.feature.launchdetail.LaunchDetailScreen
import com.adammcneilly.spacenerd.feature.launchlist.LaunchListScreen
import com.adammcneilly.spacenerd.feature.news.NewsScreen
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailScreen
import com.adammcneilly.spacenerd.feature.stationlist.SpaceStationListScreen

@Composable
fun AppNavHost(
    launchId: String?,
) {
    val startDestination = AppScreen.Tab(HomeTab.News)

    val backStack = rememberNavBackStack<AppScreen>(
        startDestination,
    )

    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(launchId) {
        if (launchId != null) {
            navigateOrReplaceLaunchDetail(launchId, backStack)
        }
    }

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

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    val isMediumOrLargerWidth = windowSizeClass.isWidthAtLeastBreakpoint(
        widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
    )

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
        sceneStrategy = TwoPaneSceneStrategy(
            isMediumOrLargerWidth = isMediumOrLargerWidth,
        ),
        entryProvider = { key ->
            navEntryProvider(key, backStack)
        },
    )
}

private fun navEntryProvider(
    key: AppScreen,
    backStack: SnapshotStateList<AppScreen>,
): NavEntry<AppScreen> =
    when (key) {
        is AppScreen.AstronautDetail -> {
            astronautDetailEntry(key)
        }

        is AppScreen.LaunchDetail -> {
            launchDetailEntry(key)
        }

        is AppScreen.StationDetail -> {
            stationDetailEntry(
                key = key,
                backStack = backStack,
            )
        }

        is AppScreen.Tab -> {
            homeTabEntry(
                key = key,
                backStack = backStack,
            )
        }
    }

private fun stationDetailEntry(
    key: AppScreen.StationDetail,
    backStack: SnapshotStateList<AppScreen>,
): NavEntry<AppScreen> {
    return NavEntry(
        key = key,
        metadata = TwoPaneScene.twoPane(),
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
        ) {
            StationDetailScreen(
                stationId = key.stationId,
                navigateToAstronaut = { astronaut ->
                    val newScreen = AppScreen.AstronautDetail(astronaut.id)

                    if (backStack.lastOrNull() is AppScreen.AstronautDetail) {
                        backStack[backStack.lastIndex] = newScreen
                    } else {
                        backStack.add(newScreen)
                    }
                },
            )
        }
    }
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

private fun astronautDetailEntry(
    key: AppScreen.AstronautDetail,
): NavEntry<AppScreen> {
    return NavEntry(
        key = key,
        metadata = TwoPaneScene.twoPane(),
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
        ) {
            AstronautDetailScreen(
                astronautId = key.astronautId,
            )
        }
    }
}

private fun homeTabEntry(
    key: AppScreen.Tab,
    backStack: SnapshotStateList<AppScreen>,
): NavEntry<AppScreen> {
    val metadata = if (key.tab.supportsTwoPane) {
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
                            navigateOrReplaceLaunchDetail(launch.id, backStack)
                        },
                    )
                }

                HomeTab.Astronauts -> {
                    AstronautListScreen()
                }

                HomeTab.Stations -> {
                    SpaceStationListScreen(
                        navigateToStation = { station ->
                            val newScreen = AppScreen.StationDetail(station.id)

                            if (backStack.lastOrNull() is AppScreen.StationDetail) {
                                backStack[backStack.lastIndex] = newScreen
                            } else {
                                backStack.add(newScreen)
                            }
                        },
                    )
                }
            }
        }
    }
}

private fun navigateOrReplaceLaunchDetail(
    launchId: String,
    backStack: SnapshotStateList<AppScreen>,
) {
    val newScreen = AppScreen.LaunchDetail(launchId)

    if (backStack.lastOrNull() is AppScreen.LaunchDetail) {
        backStack[backStack.lastIndex] = newScreen
    } else {
        backStack.add(newScreen)
    }
}
