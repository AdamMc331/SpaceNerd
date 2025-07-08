package com.adammcneilly.spacenerd.shared.data.cache.local.room

import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.shared.datetime.DateTimeProvider
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class RoomCacheTimestampRepository(
    override val dateTimeProvider: DateTimeProvider,
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
    ) {
        val dto = RoomCacheTimestampDTO(
            key = key,
            lastFetchedTime = dateTimeProvider.now().toString(),
        )

        cacheTimestampDao.insertOrUpdateTimestamp(dto)
    }
}
