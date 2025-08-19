package com.adammcneilly.spacenerd.test.paparazzi.scaffold.components

import androidx.compose.runtime.CompositionLocalProvider
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.BottomNavigationBar
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import org.junit.Test

class BottomNavigationBarPaparazziTest : BasePaparazziTest() {
    @Test
    fun render() {
        snapshot(screenPaddingDp = 0) {
            CompositionLocalProvider(
                LocalAppState provides AppState(),
            ) {
                BottomNavigationBar()
            }
        }
    }
}
