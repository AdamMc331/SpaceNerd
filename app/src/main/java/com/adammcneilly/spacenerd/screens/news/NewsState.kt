package com.adammcneilly.spacenerd.screens.news

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel

data class NewsState(
    val articles: List<ArticleDisplayModel>,
) {
    companion object {
        fun default(): NewsState {
            return NewsState(
                articles = emptyList(),
            )
        }
    }
}
