package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.datetime.Clock
import javax.inject.Inject

class OfflineFirstArticleRepository @Inject constructor(
    val localArticleRepository: LocalArticleRepository,
    val remoteArticleRepository: RemoteArticleRepository,
    val cacheTimestampRepository: CacheTimestampRepository,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleRepository.getArticles()
            .onStart {
                val lastFetchTimestamp = cacheTimestampRepository
                    .getCacheTimestamp(CacheTimestampRepository.KEY_ARTICLES)

                val currentTime = Clock.System.now()

                val needsServerFetch = lastFetchTimestamp == null || (currentTime - lastFetchTimestamp).inWholeHours >= 1

                if (needsServerFetch) {
                    val articles = remoteArticleRepository.getArticles()
                    localArticleRepository.saveArticles(articles)
                    cacheTimestampRepository.setCacheTimestamp(CacheTimestampRepository.KEY_ARTICLES, currentTime)
                }
            }
    }
}
