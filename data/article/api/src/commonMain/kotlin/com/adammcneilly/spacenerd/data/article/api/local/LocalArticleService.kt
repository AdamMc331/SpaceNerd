package com.adammcneilly.spacenerd.data.article.api.local

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

/**
 * This is a data source that requests article information from a local data source.
 *
 * All functions should return a [Flow] that emits any time the local data source changes.
 * Any functions to save data should be suspending and operate on a background thread.
 */
interface LocalArticleService {
    suspend fun saveArticles(
        articles: List<Article>,
    )

    fun getArticles(): Flow<List<Article>>
}
