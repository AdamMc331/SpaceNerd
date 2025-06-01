package com.adammcneilly.spacenerd.data.spaceflightnews

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.dto.SpaceFlightNewsArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceFlightNewsArticleRepository @Inject constructor(
    private val api: SpaceFlightNewsRetrofitAPI,
) : ArticleRepository {
    @Suppress("TooGenericExceptionCaught")
    override fun getArticles(): Flow<Result<List<Article>>> {
        return flow {
            try {
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
}
