package com.adammcneilly.spacenerd.feature.news

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel

data class NewsState(
    val articles: List<ArticleDisplayModel>,
    val selectedArticle: ArticleDisplayModel?,
) {
    companion object {
        @Suppress("MagicNumber")
        fun default(): NewsState {
            val placeholderArticles = List(3) {
                ArticleDisplayModel.placeholder()
            }

            return NewsState(
                articles = placeholderArticles,
                selectedArticle = null,
            )
        }
    }
}
