package com.adammcneilly.spacenerd.data.article.impl

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

/**
 * This is an implementation of [ArticleRepository] that prioritizes offline data, using [localArticleService]
 * as the source of truth, and only syncing with [remoteArticleService] when necessary.
 */
class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.getArticles()
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val needsServerFetch = localArticleService.isCacheStale(
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteArticleService.getArticles()

                        response.onSuccess { articles ->
                            localArticleService.saveArticles(articles)
                        }.onFailure { error ->
                            // Need to log this somewhere
                            println("Error fetching articles: $error")
                        }
                    }
                }
            }
    }
}
