package com.adammcneilly.spacenerd.shared.data.article.remote.snapi

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.shared.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.dto.SNAPIArticleDTO
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.dto.SNAPIArticleListResponseDTO
import com.adammcneilly.spacenerd.shared.data.remote.ktor.BaseKtorClient

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
