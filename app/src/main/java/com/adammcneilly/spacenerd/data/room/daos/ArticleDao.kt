package com.adammcneilly.spacenerd.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.data.room.dtos.RoomArticleDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(
        articles: List<RoomArticleDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(
        article: RoomArticleDTO,
    )

    @Query("SELECT * FROM articles ORDER BY publishedAtUtc DESC")
    fun getAllArticles(): Flow<List<RoomArticleDTO>>

    @Query("DELETE FROM articles")
    suspend fun clearAllArticles()
}
