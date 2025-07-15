package com.adammcneilly.spacenerd.data.article.local

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleService {
    suspend fun saveArticles(
        articles: List<Article>,
    )

    fun getArticles(): Flow<List<Article>>
}
