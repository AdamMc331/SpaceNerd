package com.adammcneilly.spacenerd.feature.news.ui

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus

/**
 * Defines the user friendly state of the news screen, defining all of the information
 * to display in a user friendly way.
 */
data class NewsUiState(
    val articles: List<ArticleDisplayModel>,
    val selectedArticle: ArticleDisplayModel?,
    val syncStatus: SyncStatus,
) {
    companion object {
        fun default(): NewsUiState {
            val placeholderArticles = List(3) {
                ArticleDisplayModel.placeholder()
            }

            return NewsUiState(
                articles = placeholderArticles,
                selectedArticle = null,
                syncStatus = SyncStatus.Initial,
            )
        }
    }
}
