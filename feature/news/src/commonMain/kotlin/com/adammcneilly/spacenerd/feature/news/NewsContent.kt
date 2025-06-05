package com.adammcneilly.spacenerd.feature.news

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

@Composable
fun NewsContent(
    state: NewsState,
    contentPadding: PaddingValues,
    onEvent: (NewsEvent) -> Unit,
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
            ArticleCard(
                article = article,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(NewsEvent.ArticleSelected(article))
                    }
                    .fillMaxWidth(),
            )
        }
    }
}
