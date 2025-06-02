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
    override fun getArticles(): Flow<List<Article>> {
        return flow {
            try {
                val articles = api.getArticles()
                    .results
                    ?.map(SpaceFlightNewsArticleDTO::toArticle)
                    .orEmpty()

                emit(articles)
            } catch (e: Exception) {
                println("Unable to request articles: $e")
            }
        }
    }
}
