package com.adammcneilly.spacenerd.data.article

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
    private val cacheTimestampRepository: CacheTimestampRepository,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.getArticles()
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = CACHE_KEY_ARTICLES

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteArticleService.getArticles()

                        val articles = response.getOrNull()
                        if (articles != null) {
                            localArticleService.saveArticles(articles)
                            cacheTimestampRepository.setCacheTimestamp(cacheKey)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching articles: $error")
                        }
                    }
                }
            }
    }

    companion object {
        private const val CACHE_KEY_ARTICLES = "articles"
    }
}
