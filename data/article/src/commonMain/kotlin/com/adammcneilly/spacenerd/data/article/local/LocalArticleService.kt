package com.adammcneilly.spacenerd.data.article.local

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

internal interface LocalArticleService {
    suspend fun saveArticles(
        articles: List<Article>,
    )

    fun gertArticles(): Flow<List<Article>>
}
