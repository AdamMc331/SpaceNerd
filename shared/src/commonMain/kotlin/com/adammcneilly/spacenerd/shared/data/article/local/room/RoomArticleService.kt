package com.adammcneilly.spacenerd.shared.data.article.local.room

import com.adammcneilly.spacenerd.shared.core.models.Article
import com.adammcneilly.spacenerd.shared.data.article.local.LocalArticleService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomArticleService(
    private val articleDao: RoomArticleDao,
) : LocalArticleService {
    override suspend fun saveArticles(
        articles: List<Article>,
    ) {
        val dtoList = articles.map(::RoomArticleDTO)

        articleDao.insertArticles(dtoList)
    }

    override fun getArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { dtoList ->
            dtoList.map(RoomArticleDTO::toArticle)
        }
    }
}
