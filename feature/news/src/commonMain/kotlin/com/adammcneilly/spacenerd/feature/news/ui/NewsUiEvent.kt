package com.adammcneilly.spacenerd.feature.news.ui

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel

/**
 * This defines all UI events that can occur on the news screen.
 */
sealed interface NewsUiEvent {
    /**
     * Triggered when the user clicks on an [article].
     */
    data class ArticleSelected(
        val article: ArticleDisplayModel,
    ) : NewsUiEvent

    /**
     * Triggered when a user navigates to an [article].
     */
    data class NavigatedToArticle(
        val article: ArticleDisplayModel,
    ) : NewsUiEvent
}
