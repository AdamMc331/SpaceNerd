package com.adammcneilly.spacenerd.data.cache.impl.room

import com.adammcneilly.spacenerd.data.cache.api.CacheTimestampRepository
import kotlinx.datetime.Instant

class RoomCacheTimestampRepository(
    private val cacheTimestampDao: CacheTimestampDao,
) : CacheTimestampRepository {
    override suspend fun saveLastFetchTime(
        key: String,
        fetchTime: Instant,
    ) {
        val dto = RoomCacheTimestampDTO(key, fetchTime.toString())
        cacheTimestampDao.insertOrUpdateTimestamp(dto)
    }

    override suspend fun getLastFetchTime(
        key: String,
    ): Instant? {
        return cacheTimestampDao
            .getTimestamp(key)
            ?.lastFetchedTime
            ?.let {
                Instant.parse(it)
            }
    }
}
