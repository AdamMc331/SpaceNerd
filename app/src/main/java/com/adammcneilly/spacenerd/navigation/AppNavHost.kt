package com.adammcneilly.spacenerd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.adammcneilly.spacenerd.scaffold.HomeTab
import com.adammcneilly.spacenerd.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.screens.astronauts.AstronautListScreen
import com.adammcneilly.spacenerd.screens.launchdetail.LaunchDetailScreen
import com.adammcneilly.spacenerd.screens.launches.LaunchListScreen
import com.adammcneilly.spacenerd.screens.news.NewsScreen
import com.adammcneilly.spacenerd.screens.stations.StationsListScreen

@Composable
@Suppress("LongMethod")
fun AppNavHost() {
    val startDestination = AppScreen.Tab(HomeTab.News)

    val backStack = remember {
        mutableStateListOf<AppScreen>(startDestination)
    }

    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(currentTab) {
        if (currentTab != null) {
            val previousTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab

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

    NavDisplay(
        backStack = backStack,
        sceneStrategy = TwoPaneSceneStrategy(),
        onBack = {
            backStack.removeLastOrNull()

            // If we're navigating back to a home tab, update app state.
            val newTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (newTab != null) {
                appState.onNavItemSelected(newTab)
            }
        },
        entryProvider = { key ->
            when (key) {
                is AppScreen.LaunchDetail -> {
                    NavEntry(
                        key = key,
                        metadata = TwoPaneScene.twoPane(),
                    ) {
                        LaunchDetailScreen(
                            launchId = key.launchId,
                        )
                    }
                }

                is AppScreen.Tab -> {
                    NavEntry(
                        key = key,
                        metadata = TwoPaneScene.twoPane(),
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
                }
            }
        },
    )
}
