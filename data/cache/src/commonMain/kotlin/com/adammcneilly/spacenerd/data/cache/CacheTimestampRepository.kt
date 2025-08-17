package com.adammcneilly.spacenerd.data.cache

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Defines any data requests to retrieve cache timestamp information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
@OptIn(ExperimentalTime::class)
interface CacheTimestampRepository {
    val dateTimeProvider: DateTimeProvider

    suspend fun getCacheTimestamp(
        key: String,
    ): Instant?

    suspend fun setCacheTimestamp(
        key: String,
    )

    /**
     * Retrieves the most recent cache timestamp for the [key] and checks
     * if the time between that instant and the current time
     * exceeds the [cacheDuration].
     *
     * @return True if the duration since last request exceeds [cacheDuration],
     * or if [getCacheTimestamp] for [key] is null.
     */
    suspend fun shouldSyncWithServer(
        key: String,
        cacheDuration: Duration,
    ): Boolean {
        val currentTime = dateTimeProvider.now()
        val lastFetchTimestamp = getCacheTimestamp(key)

        return if (lastFetchTimestamp == null) {
            true
        } else {
            (currentTime - cacheDuration) > lastFetchTimestamp
        }
    }
}
