package com.adammcneilly.spacenerd.test.paparazzi.scaffold.components

import androidx.compose.runtime.CompositionLocalProvider
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.scaffold.app.AppStateData
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.HomeTab
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.BottomNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.SideNavigationRail
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import com.google.testing.junit.testparameterinjector.TestParameter
import org.junit.Test

class SideNavigationRailPaparazziTest : BasePaparazziTest() {
    @Test
    fun render() {
        snapshot(screenPaddingDp = 0) {
            CompositionLocalProvider(
                LocalAppState provides AppState(),
            ) {
                SideNavigationRail()
            }
        }
    }
}
