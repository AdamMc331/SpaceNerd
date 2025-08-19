package com.adammcneilly.spacenerd.test.paparazzi.scaffold.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceTheme
import com.adammcneilly.spacenerd.core.scaffold.app.AppState
import com.adammcneilly.spacenerd.core.scaffold.app.LocalAppState
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.BottomNavigationBar
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class BottomNavigationBarPaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi()

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
                    BottomNavigationBar()
                }
            }
        }
    }
}
