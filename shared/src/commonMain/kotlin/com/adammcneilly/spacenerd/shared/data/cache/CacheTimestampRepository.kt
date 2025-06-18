package com.adammcneilly.spacenerd.shared.data.cache

import com.adammcneilly.spacenerd.shared.datetime.DateTimeProvider
import kotlinx.datetime.Instant
import kotlin.time.Duration

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
     * if the time between that instant and [currentTime]
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

    companion object {
        const val KEY_ARTICLES = "articles"
        const val KEY_LAUNCHES_PREFIX = "launches"
        const val KEY_LAUNCH_PREFIX = "launch"
    }
}
