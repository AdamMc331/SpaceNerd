package com.adammcneilly.spacenerd.data.article.impl.remote.snapi

import com.adammcneilly.spacenerd.core.data.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.article.impl.remote.snapi.dto.SNAPIArticleDTO
import com.adammcneilly.spacenerd.data.article.impl.remote.snapi.dto.SNAPIArticleListResponseDTO

class SNAPIArticleService(
    private val client: BaseKtorClient = SNAPIKtorClient,
) : RemoteArticleService {
    override suspend fun getArticles(): Result<List<Article>> {
        return client.getResponse<SNAPIArticleListResponseDTO>(
            endpoint = "v4/articles",
        ).map { articleListResponseDTO ->
            articleListResponseDTO.results
                ?.map(SNAPIArticleDTO::toArticle)
                .orEmpty()
        }
    }
}
