package com.adammcneilly.spacenerd.navigation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.Scene
import androidx.navigation3.ui.SceneStrategy
import androidx.window.core.layout.WindowSizeClass

class TwoPaneSceneStrategy<T : AppScreen> : SceneStrategy<T> {
    @Composable
    override fun calculateScene(
        entries: List<NavEntry<T>>,
        onBack: (Int) -> Unit,
    ): Scene<T>? {
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

        val isMediumOrLargerWidth = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)
        if (!isMediumOrLargerWidth) {
            return null
        }

        val lastTwoEntries = entries.takeLast(2)

        if (lastTwoEntries.size != 2) {
            return null
        }

        val entriesSupportTwoPanes = lastTwoEntries.all { entry ->
            entry.metadata[TwoPaneScene.TWO_PANE_KEY] == true
        }

        if (!entriesSupportTwoPanes) {
            return null
        }

        val firstEntry = lastTwoEntries.first()
        val secondEntry = lastTwoEntries.last()

        return TwoPaneScene(
            key = Pair(firstEntry.key, secondEntry.key),
            previousEntries = entries.dropLast(1),
            firstEntry = firstEntry,
            secondEntry = secondEntry,
        )
    }
}
