package com.adammcneilly.spacenerd.shared.data.cache.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomCacheTimestampDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTimestamp(
        cacheTimestamp: RoomCacheTimestampDTO,
    )

    @Query("SELECT * FROM cache_timestamps WHERE `key` = :dataKey")
    suspend fun getTimestamp(
        dataKey: String,
    ): RoomCacheTimestampDTO?
}
