package com.adammcneilly.spacenerd.shared.feature.news.ui

import com.adammcneilly.spacenerd.shared.core.displaymodels.ArticleDisplayModel

sealed interface NewsUiEvent {
    data class ArticleSelected(
        val article: ArticleDisplayModel,
    ) : NewsUiEvent

    data class NavigatedToArticle(
        val article: ArticleDisplayModel,
    ) : NewsUiEvent
}
