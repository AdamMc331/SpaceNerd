package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCacheTimestampDTO

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
