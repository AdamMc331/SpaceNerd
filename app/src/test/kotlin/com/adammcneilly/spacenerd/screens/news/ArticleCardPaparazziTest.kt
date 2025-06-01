package com.adammcneilly.spacenerd.screens.news

import com.adammcneilly.spacenerd.BasePaparazziTest
import com.adammcneilly.spacenerd.R
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.ImageDisplayModel
import org.junit.Test

class ArticleCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        val article = ArticleDisplayModel.placeholder()

        snapshot {
            ArticleCard(
                article = article,
            )
        }
    }

    @Test
    fun renderDefault() {
        val article = ArticleDisplayModel(
            id = "123",
            title = "Neil Armstrong Steps Foot On The Moon",
            image = ImageDisplayModel.Local(R.drawable.armstrong),
            url = "",
            summary = "Armstrong, Aldrin, and Collins complete successful Apollo 11 mission.",
            authors = listOf(
                AuthorDisplayModel(
                    name = "NASA",
                ),
            ),
        )

        snapshot {
            ArticleCard(
                article = article,
            )
        }
    }
}
