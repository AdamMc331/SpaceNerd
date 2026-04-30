package com.adammcneilly.spacenerd.feature.news.ui

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
import com.adammcneilly.spacenerd.core.designsystem.utils.plus

private const val LARGE_SCREEN_GRID_COLUMN_COUNT = 2

@Composable
fun NewsContent(
    state: NewsUiState,
    contentPadding: PaddingValues,
    onEvent: (NewsUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isMediumOrExpandedWidth = currentWindowAdaptiveInfo().windowSizeClass.isWidthAtLeastBreakpoint(
        WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
    )
    val isMediumOrExpandedHeight = currentWindowAdaptiveInfo().windowSizeClass.isHeightAtLeastBreakpoint(
        WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND,
    )

    if (isMediumOrExpandedHeight && isMediumOrExpandedWidth) {
        GridNewsContent(
            contentPadding = contentPadding,
            state = state,
            onEvent = onEvent,
            modifier = modifier,
        )
    } else {
        ColumnNewsContent(
            contentPadding = contentPadding,
            state = state,
            isCompactWidth = !isMediumOrExpandedWidth,
            onEvent = onEvent,
            modifier = modifier,
        )
    }
}

@Composable
private fun ColumnNewsContent(
    contentPadding: PaddingValues,
    state: NewsUiState,
    isCompactWidth: Boolean,
    onEvent: (NewsUiEvent) -> Unit,
    modifier: Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item {
            Text(
                text = "News",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.displayArticles) { article ->
            ArticleSummaryCard(
                article = article,
                size = if (isCompactWidth) {
                    ImageContentCard.Size.Compact
                } else {
                    ImageContentCard.Size.Expanded
                },
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(NewsUiEvent.ArticleSelected(article))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun GridNewsContent(
    contentPadding: PaddingValues,
    state: NewsUiState,
    onEvent: (NewsUiEvent) -> Unit,
    modifier: Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(LARGE_SCREEN_GRID_COLUMN_COUNT),
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        verticalItemSpacing = 16.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item(span = StaggeredGridItemSpan.FullLine) {
            Text(
                text = "News",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.displayArticles) { article ->
            ArticleSummaryCard(
                article = article,
                size = ImageContentCard.Size.Compact,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(NewsUiEvent.ArticleSelected(article))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}
