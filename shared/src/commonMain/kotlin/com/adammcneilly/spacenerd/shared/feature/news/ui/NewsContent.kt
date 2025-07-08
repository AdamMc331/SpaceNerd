package com.adammcneilly.spacenerd.shared.feature.news.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.shared.ui.utils.currentWindowHeightSizeClass
import com.adammcneilly.spacenerd.shared.ui.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.shared.ui.utils.plus

private const val LARGE_SCREEN_GRID_COLUMN_COUNT = 3

@Composable
fun NewsContent(
    state: NewsUiState,
    contentPadding: PaddingValues,
    onEvent: (NewsUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isCompactWidth = currentWindowWidthSizeClass() == WindowWidthSizeClass.Compact
    val isCompactHeight = currentWindowHeightSizeClass() == WindowHeightSizeClass.Compact

    if (isCompactHeight || isCompactWidth) {
        ColumnNewsContent(
            contentPadding = contentPadding,
            state = state,
            isCompactWidth = isCompactWidth,
            onEvent = onEvent,
            modifier = modifier,
        )
    } else {
        GridNewsContent(
            contentPadding = contentPadding,
            state = state,
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

        items(state.articles) { article ->
            ArticleSummaryCard(
                article = article,
                variant = if (isCompactWidth) {
                    ArticleSummaryCardVariant.Compact
                } else {
                    ArticleSummaryCardVariant.Expanded
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(LARGE_SCREEN_GRID_COLUMN_COUNT),
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "News",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.articles) { article ->
            ArticleSummaryCard(
                article = article,
                variant = ArticleSummaryCardVariant.Compact,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(NewsUiEvent.ArticleSelected(article))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}
