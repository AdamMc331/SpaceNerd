package com.adammcneilly.spacenerd.core.scaffold.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.spacenerd.core.scaffold.navigation.HomeTab
import com.adammcneilly.spacenerd.core.scaffold.navigation.NavItem

/**
 * A composition local provider for [AppState] allows us to
 * access app wide navigation data from within any subscreen that
 * needs it.
 */
val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

/**
 * By extracting the components out of [AppState], this data
 * class can be persisted across configuration changes
 * using rememberSaveable.
 */
data class AppStateData(
    val navItems: List<NavItem>,
) {
    constructor(
        selectedTab: HomeTab = HomeTab.News,
    ) : this(
        navItems = HomeTab.entries.map { tab ->
            NavItem(
                tab = tab,
                selected = (tab == selectedTab),
            )
        },
    )
}

/**
 * The application state container, it's main purpose to expose the
 * shared business logic like navigation state via [navItems].
 */
class AppState(
    initialData: AppStateData = AppStateData(),
) {
    var navItems: List<NavItem> by mutableStateOf(initialData.navItems)
        private set

    val currentSelectedTab: HomeTab?
        get() = navItems
            .firstOrNull { navItem ->
                navItem.selected
            }?.tab

    fun onNavItemSelected(
        tab: HomeTab,
    ) {
        navItems = navItems.map { navItem ->
            navItem.copy(
                selected = (navItem.tab == tab),
            )
        }
    }

    companion object {
        val saver = Saver<AppState, String>(
            save = { appState ->
                appState.currentSelectedTab?.name
            },
            restore = { tabName ->
                val selectedTab = HomeTab.entries.find { it.name == tabName } ?: HomeTab.News
                AppState(AppStateData(selectedTab))
            },
        )
    }
}
