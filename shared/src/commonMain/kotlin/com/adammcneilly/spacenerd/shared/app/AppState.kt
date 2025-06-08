package com.adammcneilly.spacenerd.shared.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.spacenerd.shared.navigation.HomeTab
import com.adammcneilly.spacenerd.shared.navigation.NavItem

/**
 * A composition local provider for [AppState] allows us to
 * access app wide navigation data from within any subscreen that
 * needs it.
 */
val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

/**
 * The application state container, it's main purpose to expose the
 * shared business logic like navigation state via [navItems].
 */
class AppState(
    initialNavItems: List<NavItem>,
) {
    var navItems: List<NavItem> by mutableStateOf(initialNavItems)
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
}
