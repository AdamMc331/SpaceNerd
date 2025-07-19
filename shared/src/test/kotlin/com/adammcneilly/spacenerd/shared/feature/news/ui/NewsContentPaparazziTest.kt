package com.adammcneilly.spacenerd.shared.feature.news.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.Author
import com.adammcneilly.spacenerd.feature.news.ui.NewsContent
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiState
import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class NewsContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        val articles = List(10) { index ->
            Article(
                id = index.toString(),
                title = "Neil Armstrong Steps Foot On The Moon",
                imageUrl = "",
                url = "",
                summary = "Armstrong, Aldrin, and Collins complete successful Apollo 11 mission.",
                publishedAtUtc = Instant.parse("2025-06-15T22:01:57Z"),
                authors = listOf(
                    Author(
                        name = "NASA",
                    ),
                ),
                isFeatured = false,
            )
        }

        val displayModels = articles.map(::ArticleDisplayModel)

        val state = NewsUiState(
            articles = displayModels,
            selectedArticle = null,
        )

        snapshot(screenPaddingDp = 0) {
            NewsContent(
                state = state,
                contentPadding = PaddingValues(16.dp),
                onEvent = {},
            )
        }
    }
}
