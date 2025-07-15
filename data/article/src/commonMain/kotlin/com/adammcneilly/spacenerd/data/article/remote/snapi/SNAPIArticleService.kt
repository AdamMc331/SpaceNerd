package com.adammcneilly.spacenerd.data.article.remote.snapi

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.snapi.dtos.SNAPIArticleDTO
import com.adammcneilly.spacenerd.data.remote.snapi.dtos.SNAPIArticleListResponseDTO

class SNAPIArticleService(
    private val client: BaseKtorClient,
) : RemoteArticleService {
    override suspend fun getArticles(): Result<List<Article>> {
        return client.getResponse<SNAPIArticleListResponseDTO>(
            endpoint = "v4/articles",
        ).map { articleListResponse ->
            articleListResponse.results
                ?.map(SNAPIArticleDTO::toArticle)
                .orEmpty()
        }
    }
}
