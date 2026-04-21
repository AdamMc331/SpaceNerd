package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomArticleDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the articles table.
 */
@Dao
interface RoomArticleDao {
    @Upsert
    suspend fun upsertArticles(
        articles: List<RoomArticleDTO>,
    )

    @Query(
        """
        SELECT * 
        FROM articles 
        ORDER BY publishedAtUtc DESC 
    """,
    )
    fun getAllArticles(): Flow<List<RoomArticleDTO>>

    @Query(
        """
            SELECT lastPersistedAtUtc
            FROM articles
            ORDER BY lastPersistedAtUtc DESC
            LIMIT 1
        """,
    )
    suspend fun getLatestCacheTimestamp(): String?
}
