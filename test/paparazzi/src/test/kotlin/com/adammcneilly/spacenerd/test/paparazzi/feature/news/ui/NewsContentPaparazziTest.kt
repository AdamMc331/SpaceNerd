package com.adammcneilly.spacenerd.test.paparazzi.feature.news.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testArticle
import com.adammcneilly.spacenerd.feature.news.ui.NewsContent
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiState
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class NewsContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        val articles = List(10) { index ->
            testArticle.copy(
                id = index.toString(),
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
