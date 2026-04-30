package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.utils.LocalSceneType
import com.adammcneilly.spacenerd.core.designsystem.utils.SceneType
import com.adammcneilly.spacenerd.core.designsystem.utils.plus

private const val LARGE_SCREEN_GRID_COLUMN_COUNT = 2

@Composable
fun AstronautListContent(
    state: AstronautListUiState,
    onEvent: (AstronautListUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isMediumOrExpandedWidth = currentWindowAdaptiveInfo().windowSizeClass.isWidthAtLeastBreakpoint(
        WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
    )
    val isMediumOrExpandedHeight = currentWindowAdaptiveInfo().windowSizeClass.isHeightAtLeastBreakpoint(
        WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND,
    )
    val isTwoPane = LocalSceneType.current == SceneType.TwoPane

    if (isMediumOrExpandedHeight && isMediumOrExpandedWidth && !isTwoPane) {
        GridAstronautContent(
            state = state,
            onEvent = onEvent,
            modifier = modifier,
        )
    } else {
        ColumnAstronautContent(
            state = state,
            isCompactWidth = !isMediumOrExpandedWidth,
            onEvent = onEvent,
            modifier = modifier,
        )
    }
}

@Composable
private fun GridAstronautContent(
    state: AstronautListUiState,
    onEvent: (AstronautListUiEvent) -> Unit,
    modifier: Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(LARGE_SCREEN_GRID_COLUMN_COUNT),
        contentPadding = PaddingValues(16.dp),
        verticalItemSpacing = 16.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item(span = StaggeredGridItemSpan.FullLine) {
            Text(
                text = "Astronauts",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.displayAstronauts) { astronaut ->
            AstronautCard(
                astronaut = astronaut,
                size = ImageContentCard.Size.Compact,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(AstronautListUiEvent.AstronautSelected(astronaut))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun ColumnAstronautContent(
    state: AstronautListUiState,
    isCompactWidth: Boolean,
    onEvent: (AstronautListUiEvent) -> Unit,
    modifier: Modifier,
) {
    val cardSize = if (isCompactWidth) {
        ImageContentCard.Size.Compact
    } else {
        ImageContentCard.Size.Expanded
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier,
    ) {
        item {
            Text(
                text = "Astronauts",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.displayAstronauts) { astronaut ->
            AstronautCard(
                astronaut = astronaut,
                size = cardSize,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(AstronautListUiEvent.AstronautSelected(astronaut))
                    },
            )
        }
    }
}
