package com.adammcneilly.spacenerd.shared.feature.news.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.shared.ui.utils.plus

@Composable
fun NewsContent(
    state: NewsUiState,
    contentPadding: PaddingValues,
    onEvent: (NewsUiEvent) -> Unit,
    modifier: Modifier = Modifier,
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
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(NewsUiEvent.ArticleSelected(article))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}
