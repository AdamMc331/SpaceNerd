package com.adammcneilly.spacenerd.screens.news

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.DataResult

data class NewsState(
    val articleData: DataResult<List<ArticleDisplayModel>>,
) {
    companion object {
        fun default(): NewsState {
            return NewsState(
                articleData = DataResult.Loading,
            )
        }
    }
}
