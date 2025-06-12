package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.shared.core.models.Article
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

                val needsServerFetch = if (lastFetchTimestamp == null) {
                    true
                } else {
                    (currentTime - lastFetchTimestamp).inWholeHours >= 1
                }

                if (needsServerFetch) {
                    val response = remoteArticleRepository.getArticles()

                    val articles = response.getOrNull()
                    if (articles != null) {
                        localArticleRepository.saveArticles(articles)
                        cacheTimestampRepository.setCacheTimestamp(CacheTimestampRepository.KEY_ARTICLES, currentTime)
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
