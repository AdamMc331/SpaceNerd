package com.adammcneilly.spacenerd.data.cache.impl.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheTimestampDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTimestamp(
        cacheTimestamp: RoomCacheTimestampDTO,
    )

    @Query("SELECT * FROM cache_timestamps WHERE `key` = :dataKey")
    suspend fun getTimestamp(
        dataKey: String,
    ): RoomCacheTimestampDTO?
}
