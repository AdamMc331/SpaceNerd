package com.adammcneilly.spacenerd.data.article.api

import com.adammcneilly.spacenerd.core.datetime.TimeProvider
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.cache.api.CacheTimestampRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

private val articleThrottleDuration = 15.minutes

class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val timeProvider: TimeProvider,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.gertArticles()
            .onStart {
                val needsServerRefresh = needsServerRefresh()

                if (!needsServerRefresh) {
                    return@onStart
                }

                refreshArticlesFromServer()
            }
    }

    /**
     * Determines if we should refresh the articles from server
     * by comparing the time since the last articles request cache
     * to the [ARTICLE_THROTTLE_DURATION].
     */
    private suspend fun needsServerRefresh(): Boolean {
        val now = timeProvider.now()
        val lastRequestTime = cacheTimestampRepository.getLastFetchTime(ARTICLES_CACHE_KEY)

        return if (lastRequestTime == null) {
            true
        } else {
            val durationSinceLastRequest = (now - lastRequestTime)
            durationSinceLastRequest > ARTICLE_THROTTLE_DURATION
        }
    }

    @Suppress("ForbiddenComment")
    private suspend fun refreshArticlesFromServer() {
        val response = remoteArticleService.getArticles()

        val articles = response.getOrNull()
        if (articles != null) {
            localArticleService.saveArticles(articles)
        }

        val error = response.exceptionOrNull()
        if (error != null) {
            // TODO: Need to log this somewhere
            println("Error fetching articles: $error")
        }
    }

    companion object {
        private val ARTICLE_THROTTLE_DURATION = 1.hours
        private const val ARTICLES_CACHE_KEY = "Articles"
    }
}
