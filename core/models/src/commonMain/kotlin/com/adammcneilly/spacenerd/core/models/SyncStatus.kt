package com.adammcneilly.spacenerd.core.models

/**
 * Consider moving to a shared data package?
 *
 * Defines the status of a sync between a local and remote data source.
 */
enum class SyncStatus {
    /**
     * Indicates no syncing is happening between two data sources.
     */
    None,

    /**
     * Indicates a local data source was empty, and an initial sync with the
     * network has begun.
     */
    Initial,

    /**
     * Indicates a local data source had data that was stale and a refresh
     * sync is happening with the network.
     */
    Refresh,
}
