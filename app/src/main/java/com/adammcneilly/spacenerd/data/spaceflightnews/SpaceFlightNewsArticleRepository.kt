package com.adammcneilly.spacenerd.data.spaceflightnews

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.DataResult
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.dto.SpaceFlightNewsArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceFlightNewsArticleRepository @Inject constructor(
    private val api: SpaceFlightNewsRetrofitAPI,
) : ArticleRepository {
    override fun getArticles(): Flow<DataResult<List<Article>>> {
        return flow {
            emit(DataResult.Loading)

            try {
                val articles = api.getArticles()
                    .results
                    ?.map(SpaceFlightNewsArticleDTO::toArticle)
                    .orEmpty()

                emit(DataResult.Success(articles))
            } catch (e: Exception) {
                emit(DataResult.Error(e))
            }
        }
    }
}
