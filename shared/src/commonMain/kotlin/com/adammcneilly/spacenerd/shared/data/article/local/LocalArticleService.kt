package com.adammcneilly.spacenerd.shared.data.article.local

import com.adammcneilly.spacenerd.shared.core.models.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleService {
    suspend fun saveArticles(
        articles: List<Article>,
    )

    fun getArticles(): Flow<List<Article>>
}
