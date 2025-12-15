package com.adammcneilly.spacenerd.data.article.impl

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

/**
 * This is an implementation of [ArticleRepository] that prioritizes offline data, using [localArticleService]
 * as the source of truth, and only syncing with [remoteArticleService] when necessary.
 */
class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
) : ArticleRepository {
    private val mutableSyncStatus = MutableStateFlow(SyncStatus.None)
    override val syncStatus: Flow<SyncStatus> = mutableSyncStatus.asStateFlow()

    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.getArticles()
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val needsServerFetch = localArticleService.isCacheStale()

                    if (needsServerFetch) {
                        setSyncStatus(SyncStatus.Refresh)
                        val response = remoteArticleService.getArticles()

                        response.onSuccess { articles ->
                            setSyncStatus(SyncStatus.None)
                            localArticleService.saveArticles(articles)
                        }.onFailure { error ->
                            setSyncStatus(SyncStatus.None)
                            // Need to log this somewhere
                            println("Error fetching articles: $error")
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
}
