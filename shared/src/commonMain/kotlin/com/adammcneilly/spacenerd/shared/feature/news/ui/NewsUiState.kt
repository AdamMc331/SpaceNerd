package com.adammcneilly.spacenerd.shared.feature.news.ui

import com.adammcneilly.spacenerd.shared.core.displaymodels.ArticleDisplayModel

data class NewsUiState(
    val articles: List<ArticleDisplayModel>,
    val selectedArticle: ArticleDisplayModel?,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): NewsUiState {
            val placeholderArticles = List(3) {
                ArticleDisplayModel.placeholder()
            }

            return NewsUiState(
                articles = placeholderArticles,
                selectedArticle = null,
            )
        }
    }
}
