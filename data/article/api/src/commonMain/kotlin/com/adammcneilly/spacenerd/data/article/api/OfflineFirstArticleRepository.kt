package com.adammcneilly.spacenerd.data.article.api

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart

@Suppress("ForbiddenComment")
class OfflineFirstArticleRepository(
    private val localArticleService: LocalArticleService,
    private val remoteArticleService: RemoteArticleService,
) : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return localArticleService.gertArticles()
            .onStart {
                // TODO: Limit based on request duration
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
    }
}
