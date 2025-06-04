package com.adammcneilly.spacenerd.data.article.impl.local.room

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomArticleService(
    private val articleDao: ArticleDao,
) : LocalArticleService {
    override suspend fun saveArticles(
        articles: List<Article>,
    ) {
        val dtoList = articles.map(::RoomArticleDTO)

        articleDao.insertArticles(dtoList)
    }

    override fun gertArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { roomArticles ->
            roomArticles.map(RoomArticleDTO::toArticle)
        }
    }
}
