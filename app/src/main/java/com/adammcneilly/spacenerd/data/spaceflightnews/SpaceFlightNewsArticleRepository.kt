package com.adammcneilly.spacenerd.data.spaceflightnews

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.dto.SpaceFlightNewsArticleDTO

class SpaceFlightNewsArticleRepository(
    private val api: SpaceFlightNewsRetrofitAPI,
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> =
        api
            .getArticles()
            .results
            ?.map(SpaceFlightNewsArticleDTO::toArticle)
            .orEmpty()
}
