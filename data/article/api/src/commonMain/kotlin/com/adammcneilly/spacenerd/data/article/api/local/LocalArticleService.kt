package com.adammcneilly.spacenerd.data.article.api.local

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration

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

    /**
     * Checks if the article cache is older than the provided [cacheDuration].
     *
     * @return True if the cache is empty or the most recently cached article
     * is older than the [cacheDuration], indicating a sync is needed.
     */
    suspend fun isCacheStale(
        cacheDuration: Duration,
    ): Boolean
}
