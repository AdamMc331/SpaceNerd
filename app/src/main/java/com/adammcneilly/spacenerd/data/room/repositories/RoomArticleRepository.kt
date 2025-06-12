package com.adammcneilly.spacenerd.data.room.repositories

import com.adammcneilly.spacenerd.data.repositories.LocalArticleRepository
import com.adammcneilly.spacenerd.data.room.daos.ArticleDao
import com.adammcneilly.spacenerd.data.room.dtos.RoomArticleDTO
import com.adammcneilly.spacenerd.shared.core.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomArticleRepository @Inject constructor(
    private val articleDao: ArticleDao,
) : LocalArticleRepository {
    override suspend fun saveArticles(
        articles: List<Article>,
    ) {
        val dtoList = articles.map(::RoomArticleDTO)

        articleDao.insertArticles(dtoList)
    }

    override fun getArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { dtoList ->
            dtoList.map {
                it.toArticle()
            }
        }
    }
}
