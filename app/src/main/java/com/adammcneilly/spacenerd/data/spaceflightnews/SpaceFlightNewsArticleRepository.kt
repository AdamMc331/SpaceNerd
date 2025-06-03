package com.adammcneilly.spacenerd.data.spaceflightnews

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.repositories.RemoteArticleRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.dto.SpaceFlightNewsArticleDTO
import javax.inject.Inject

class SpaceFlightNewsArticleRepository @Inject constructor(
    private val api: SpaceFlightNewsRetrofitAPI,
) : RemoteArticleRepository {
    override suspend fun getArticles(): Result<List<Article>> {
        return try {
            val articles = api.getArticles()
                .results
                ?.map(SpaceFlightNewsArticleDTO::toArticle)
                .orEmpty()

            Result.success(articles)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
