package com.adammcneilly.spacenerd.shared.data.cache.local.room

import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import kotlinx.datetime.Instant

class RoomCacheTimestampRepository(
    private val cacheTimestampDao: RoomCacheTimestampDao,
) : CacheTimestampRepository {
    override suspend fun getCacheTimestamp(
        key: String,
    ): Instant? {
        return cacheTimestampDao.getTimestamp(key)?.lastFetchedTime?.let { time ->
            Instant.parse(time)
        }
    }

    override suspend fun setCacheTimestamp(
        key: String,
        timestamp: Instant,
    ) {
        val dto = RoomCacheTimestampDTO(
            key = key,
            lastFetchedTime = timestamp.toString(),
        )

        cacheTimestampDao.insertOrUpdateTimestamp(dto)
    }
}
