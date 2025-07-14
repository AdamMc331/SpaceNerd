package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache_timestamps")
data class RoomCacheTimestampDTO(
    @PrimaryKey val key: String,
    val lastFetchedTime: String,
)
