package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCacheTimestampDTO

/**
 * This defines the local Room database access object for the cache timestamps table.
 */
@Dao
interface RoomCacheTimestampDao {
    @Upsert
    suspend fun upsertTimestamp(
        cacheTimestamp: RoomCacheTimestampDTO,
    )

    @Query("SELECT * FROM cache_timestamps WHERE `key` = :dataKey")
    suspend fun getTimestamp(
        dataKey: String,
    ): RoomCacheTimestampDTO?
}
