package com.adammcneilly.spacenerd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.adammcneilly.spacenerd.scaffold.HomeTab
import com.adammcneilly.spacenerd.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.screens.astronauts.AstronautListScreen
import com.adammcneilly.spacenerd.screens.launchdetail.LaunchDetailScreen
import com.adammcneilly.spacenerd.screens.launches.LaunchListScreen
import com.adammcneilly.spacenerd.screens.news.NewsScreen
import com.adammcneilly.spacenerd.screens.stations.StationsListScreen

@Composable
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
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        onBack = {
            backStack.removeLastOrNull()

            // If we're navigating back to a home tab, update app state.
            val newTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (newTab != null) {
                appState.onNavItemSelected(newTab)
            }
        },
        entryProvider = { key ->
            NavEntry(key) {
                CompositionLocalProvider(
                    // We can probably remove our own local animated visibility scope
                    // with the composition local from Nav3.
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
                                navigator = {
                                    backStack.add(it)
                                },
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
    navigator: (AppScreen) -> Unit,
) {
    when (key.tab) {
        HomeTab.News -> {
            NewsScreen()
        }

        HomeTab.Launches -> {
            LaunchListScreen(
                navigateToLaunch = { launch ->
                    navigator.invoke(AppScreen.LaunchDetail(launch.id))
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
