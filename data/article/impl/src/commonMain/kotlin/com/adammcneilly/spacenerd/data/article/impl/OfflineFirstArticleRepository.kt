package com.adammcneilly.spacenerd.data.article.impl

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val dateTimeProvider: DateTimeProvider,
) : ArticleRepository {
    private val mutableSyncStatus = MutableStateFlow(SyncStatus.None)
    override val syncStatus: Flow<SyncStatus> = mutableSyncStatus.asStateFlow()

    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.getArticles()
            .onStart {
                syncArticlesIfNecessary()
            }
    }

    private suspend fun syncArticlesIfNecessary() {
        coroutineScope {
            launch {
                val cacheKey = KEY_ARTICLES

                val lastCache = cacheTimestampRepository.getCacheTimestamp(cacheKey)
                val now = dateTimeProvider.now()
                val cacheDuration = 1.hours

                when {
                    lastCache == null -> {
                        setSyncStatus(SyncStatus.Initial)
                        requestArticles(cacheKey)
                    }

                    (now - lastCache) > cacheDuration -> {
                        setSyncStatus(SyncStatus.Refresh)
                        requestArticles(cacheKey)
                    }

                    else -> {
                        setSyncStatus(SyncStatus.None)
                    }
                }
            }
        }
    }

    private fun setSyncStatus(
        status: SyncStatus,
    ) {
        mutableSyncStatus.value = status
    }

    private suspend fun requestArticles(
        cacheKey: String,
    ) {
        val response = remoteArticleService.getArticles()

        val articles = response.getOrNull()
        if (articles != null) {
            localArticleService.saveArticles(articles)
            cacheTimestampRepository.setCacheTimestamp(cacheKey)
            setSyncStatus(SyncStatus.None)
        }

        val error = response.exceptionOrNull()
        if (error != null) {
            // Need to log this somewhere
            println("Error fetching articles: \$error")
            setSyncStatus(SyncStatus.None)
        }
    }

    companion object {
        private const val KEY_ARTICLES = "articles"
    }
}
