package com.adammcneilly.spacenerd.shared.navigation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.shared.app.LocalAppState

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
) {
    val appState = LocalAppState.current

    NavigationBar(
        modifier = modifier,
    ) {
        appState.navItems.forEach { item ->
            NavigationBarItem(
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
