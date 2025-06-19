package com.adammcneilly.spacenerd.navigation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.Scene
import androidx.navigation3.ui.SceneStrategy
import androidx.window.core.layout.WindowSizeClass

class TwoPaneSceneStrategy : SceneStrategy<AppScreen> {
    @Composable
    @Suppress("ReturnCount")
    override fun calculateScene(
        entries: List<NavEntry<AppScreen>>,
        onBack: (Int) -> Unit,
    ): Scene<AppScreen>? {
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

        val isMediumOrLargerWidth = windowSizeClass.isWidthAtLeastBreakpoint(
            widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
        )

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

        val bothEntriesAreTabs = lastTwoEntries.all { entry ->
            entry.key is AppScreen.Tab
        }

        if (bothEntriesAreTabs) {
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
