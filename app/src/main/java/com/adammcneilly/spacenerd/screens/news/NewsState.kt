package com.adammcneilly.spacenerd.screens.news

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel

data class NewsState(
    val articles: Result<List<ArticleDisplayModel>>,
    val selectedArticle: ArticleDisplayModel?,
) {
    companion object {
        fun default(): NewsState {
            val placeholderArticles = List(3) {
                ArticleDisplayModel.placeholder()
            }

            return NewsState(
                articles = Result.success(placeholderArticles),
                selectedArticle = null,
            )
        }
    }
}
