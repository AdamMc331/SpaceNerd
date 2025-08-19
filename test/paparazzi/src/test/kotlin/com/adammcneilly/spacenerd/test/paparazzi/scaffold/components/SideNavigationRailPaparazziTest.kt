package com.adammcneilly.spacenerd.test.paparazzi.scaffold.components

import androidx.compose.runtime.CompositionLocalProvider
import app.cash.paparazzi.Paparazzi
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceTheme
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.SideNavigationRail
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class SideNavigationRailPaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = app.cash.paparazzi.DeviceConfig.PIXEL_C,
    )

    @TestParameter
    val useDarkTheme: Boolean = false

    @Test
    fun render() {
        paparazzi.snapshot {
            CompositionLocalProvider(
                LocalAppState provides AppState(),
            ) {
                SpaceTheme(
                    darkTheme = useDarkTheme,
                ) {
                    SideNavigationRail()
                }
            }
        }
    }
}
