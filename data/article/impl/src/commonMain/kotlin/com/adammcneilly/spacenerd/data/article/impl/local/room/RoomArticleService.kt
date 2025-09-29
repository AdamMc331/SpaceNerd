package com.adammcneilly.spacenerd.data.article.impl.local.room

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomArticleDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Implementation of [LocalArticleService] that will request data from a Room database via [articleDao].
 */
class RoomArticleService(
    private val articleDao: RoomArticleDao,
    private val dateTimeProvider: DateTimeProvider,
) : LocalArticleService {
    override suspend fun saveArticles(
        articles: List<Article>,
    ) {
        val dtoList = articles.map { article ->
            RoomArticleDTO(
                article = article,
                dateTimeProvider = dateTimeProvider,
            )
        }

        articleDao.insertArticles(dtoList)
    }

    override fun getArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { dtoList ->
            dtoList.map(RoomArticleDTO::toArticle)
        }
    }
}
