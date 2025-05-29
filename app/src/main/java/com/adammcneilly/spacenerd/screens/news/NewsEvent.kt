package com.adammcneilly.spacenerd.screens.news

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel

sealed interface NewsEvent {
    data class ArticleSelected(
        val article: ArticleDisplayModel,
    ) : NewsEvent

    data class NavigatedToArticle(
        val article: ArticleDisplayModel,
    ) : NewsEvent
}
