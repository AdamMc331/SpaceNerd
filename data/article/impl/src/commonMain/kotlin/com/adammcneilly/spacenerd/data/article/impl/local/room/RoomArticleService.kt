package com.adammcneilly.spacenerd.data.article.impl.local.room

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomArticleDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Implementation of [LocalArticleService] that will request data from a Room database via [articleDao].
 */
@OptIn(ExperimentalTime::class)
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

        articleDao.upsertArticles(dtoList)
    }

    override fun getArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { dtoList ->
            dtoList.map(RoomArticleDTO::toArticle)
        }
    }

    override suspend fun isCacheStale(): Boolean {
        val cacheDuration = 12.hours

        val latestCacheTimestamp = articleDao.getLatestCacheTimestamp()?.let {
            Instant.parse(it)
        }

        // If no saved timestamp, consider cache stale and needs to be updated.
        if (latestCacheTimestamp == null) {
            return true
        }

        val now = dateTimeProvider.now()

        val durationSinceCache = (now - latestCacheTimestamp)

        return durationSinceCache > cacheDuration
    }
}
