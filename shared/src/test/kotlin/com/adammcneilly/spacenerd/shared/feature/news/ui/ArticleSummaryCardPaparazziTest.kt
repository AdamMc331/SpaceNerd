package com.adammcneilly.spacenerd.shared.feature.news.ui

import com.adammcneilly.spacenerd.shared.BasePaparazziTest
import com.adammcneilly.spacenerd.shared.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.shared.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.shared.core.models.Article
import com.adammcneilly.spacenerd.shared.core.models.Author
import org.junit.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class ArticleSummaryCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        val article = ArticleDisplayModel.placeholder()

        snapshot {
            ArticleSummaryCard(
                article = article,
            )
        }
    }

    @Test
    fun renderDefault() {
        val article = Article(
            id = "123",
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
        )

        val displayModel = ArticleDisplayModel(article).copy(
            image = ImageDisplayModel.Placeholder,
        )

        snapshot {
            ArticleSummaryCard(
                article = displayModel,
            )
        }
    }
}
