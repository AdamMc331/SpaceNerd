package com.adammcneilly.spacenerd.data.article.impl.remote.snapi

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.snapi.dtos.SNAPIArticleDTO
import com.adammcneilly.spacenerd.data.remote.snapi.dtos.SNAPIArticleListResponseDTO

/**
 * Implementation of a [RemoteArticleService] that requests data from a
 * Spaceflight News API [client].
 *
 * We ensure the type is [BaseKtorClient] so we can supply a mock during tests.
 */
class SNAPIArticleService(
    private val client: BaseKtorClient,
) : RemoteArticleService {
    override suspend fun getArticles(): Result<List<Article>> {
        return client.getResponse<SNAPIArticleListResponseDTO>(
            endpoint = "articles",
        ).map { articleListResponse ->
            articleListResponse.results
                ?.map(SNAPIArticleDTO::toArticle)
                .orEmpty()
        }
    }
}
