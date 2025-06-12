package com.adammcneilly.spacenerd.shared.data.article

import com.adammcneilly.spacenerd.shared.core.models.Article
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.hours

class OfflineFirstArticleRepository(
    val localArticleService: LocalArticleService,
    val remoteArticleService: RemoteArticleService,
    val cacheTimestampRepository: CacheTimestampRepository,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.getArticles()
            .onStart {
                val cacheKey = CacheTimestampRepository.KEY_ARTICLES

                val currentTime = Clock.System.now()

                val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                    key = cacheKey,
                    currentTime = currentTime,
                    cacheDuration = 1.hours,
                )

                if (needsServerFetch) {
                    val response = remoteArticleService.getArticles()

                    val articles = response.getOrNull()
                    if (articles != null) {
                        localArticleService.saveArticles(articles)
                        cacheTimestampRepository.setCacheTimestamp(cacheKey, currentTime)
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
