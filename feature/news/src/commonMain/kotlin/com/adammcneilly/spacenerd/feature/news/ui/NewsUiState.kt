package com.adammcneilly.spacenerd.feature.news.ui

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus

/**
 * Defines the user friendly state of the news screen, defining all of the information
 * to display in a user friendly way.
 */
data class NewsUiState(
    private val articles: List<ArticleDisplayModel>,
    val selectedArticle: ArticleDisplayModel?,
    val syncStatus: SyncStatus,
) {
    /**
     * If we're syncing data for the initial time of running the app,
     * we can override and display a few loading articles instead of
     * the empty list from our local data source.
     */
    val displayArticles = when (syncStatus) {
        SyncStatus.Initial -> {
            List(3) {
                ArticleDisplayModel.placeholder()
            }
        }

        else -> {
            articles
        }
    }

    companion object {
        fun default(): NewsUiState {
            return NewsUiState(
                articles = emptyList(),
                selectedArticle = null,
                syncStatus = SyncStatus.Initial,
            )
        }
    }
}
