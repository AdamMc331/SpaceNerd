package com.adammcneilly.spacenerd.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.Scene

class TwoPaneScene<T : AppScreen>(
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>,
    val firstEntry: NavEntry<T>,
    val secondEntry: NavEntry<T>,
) : Scene<T> {
    override val entries: List<NavEntry<T>> = listOf(
        firstEntry,
        secondEntry,
    )

    override val content: @Composable (() -> Unit) = {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .weight(1F),
            ) {
                firstEntry.content.invoke(firstEntry.key)
            }

            Box(
                modifier = Modifier
                    .weight(2F),
            ) {
                secondEntry.content.invoke(secondEntry.key)
            }
        }
    }

    companion object {
        const val TWO_PANE_KEY = "TwoPane"

        /**
         * Helper function to add metadata to a [NavEntry] indicating it can be displayed
         * in a two-pane layout.
         */
        fun twoPane() = mapOf(TWO_PANE_KEY to true)
    }
}
