package com.adammcneilly.spacenerd.screens.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.ui.utils.plus
import com.adammcneilly.spacenerd.data.DataResult

@Composable
fun NewsContent(
    state: NewsState,
    contentPadding: PaddingValues,
    onEvent: (NewsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (state.articleData) {
        is DataResult.Error -> {
            ErrorMessage(
                message = state.articleData.error.message,
                modifier = modifier
                    .fillMaxSize()
                    .padding(contentPadding),
            )
        }
        DataResult.Loading -> {
            LoadingScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(contentPadding),
            )
        }
        is DataResult.Success<List<ArticleDisplayModel>> -> {
            ArticleList(
                contentPadding = contentPadding,
                articles = state.articleData.data,
                onArticleClicked = { article ->
                    onEvent.invoke(NewsEvent.ArticleSelected(article))
                },
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
        )
    }
}

@Composable
private fun ErrorMessage(
    message: String?,
    modifier: Modifier = Modifier,
) {
    Text(
        text = message.orEmpty(),
        modifier = modifier,
    )
}

@Composable
private fun ArticleList(
    contentPadding: PaddingValues,
    articles: List<ArticleDisplayModel>,
    onArticleClicked: (ArticleDisplayModel) -> Unit,
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

        items(articles) { article ->
            ArticleCard(
                article = article,
                modifier = Modifier
                    .clickable {
                        onArticleClicked.invoke(article)
                    }
                    .fillMaxWidth(),
            )
        }
    }
}
