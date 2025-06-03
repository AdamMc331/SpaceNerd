package com.adammcneilly.spacenerd.data.room.repositories

import com.adammcneilly.spacenerd.data.repositories.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.room.daos.CacheTimestampDao
import com.adammcneilly.spacenerd.data.room.dtos.RoomCacheTimestampDTO
import kotlinx.datetime.Instant
import javax.inject.Inject

class RoomCacheTimestampRepository @Inject constructor(
    private val cacheTimestampDao: CacheTimestampDao,
) : CacheTimestampRepository {
    override suspend fun getCacheTimestamp(
        key: String,
    ): Instant? {
        return cacheTimestampDao
            .getTimestamp(key)
            ?.lastFetchedTime
            ?.let {
                Instant.parse(it)
            }
    }

    override suspend fun setCacheTimestamp(
        key: String,
        timestamp: Instant,
    ) {
        val dto = RoomCacheTimestampDTO(key, timestamp.toString())
        cacheTimestampDao.insertOrUpdateTimestamp(dto)
    }
}
