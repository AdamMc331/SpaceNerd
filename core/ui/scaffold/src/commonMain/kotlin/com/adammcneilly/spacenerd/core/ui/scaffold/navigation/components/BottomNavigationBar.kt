package com.adammcneilly.spacenerd.core.ui.scaffold.navigation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adammcneilly.spacenerd.core.ui.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.scaffold.app.AppState
import com.adammcneilly.spacenerd.scaffold.app.AppStateData
import com.adammcneilly.spacenerd.scaffold.ui.theme.SpaceTheme

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
                        contentDescription = stringResource(item.tab.label),
                    )
                },
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewDynamicColors
private fun BottomNavigationBarPreview() {
    SpaceTheme {
        CompositionLocalProvider(
            LocalAppState provides AppState(AppStateData()),
        ) {
            BottomNavigationBar()
        }
    }
}
