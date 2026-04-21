package com.adammcneilly.spacenerd.data.cache.room

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.local.room.daos.RoomCacheTimestampDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCacheTimestampDTO
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * This is an implementation of [CacheTimestampRepository] that request data from a local Room [cacheTimestampDao].
 */
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

        cacheTimestampDao.upsertTimestamp(dto)
    }
}
