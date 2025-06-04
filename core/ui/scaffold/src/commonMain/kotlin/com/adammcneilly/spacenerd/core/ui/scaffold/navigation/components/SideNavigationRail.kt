package com.adammcneilly.spacenerd.core.ui.scaffold.navigation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.ui.scaffold.app.LocalAppState

@Composable
fun SideNavigationRail(
    modifier: Modifier = Modifier,
) {
    val appState = LocalAppState.current

    NavigationRail(
        modifier = modifier,
    ) {
        appState.navItems.forEach { item ->
            NavigationRailItem(
                selected = item.selected,
                onClick = {
                    appState.onNavItemSelected(item.tab)
                },
                icon = {
                    Icon(
                        imageVector = item.tab.icon,
                        contentDescription = item.tab.label,
                    )
                },
            )
        }
    }
}
