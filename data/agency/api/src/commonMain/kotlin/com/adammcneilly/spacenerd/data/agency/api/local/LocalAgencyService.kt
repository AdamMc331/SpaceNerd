package com.adammcneilly.spacenerd.data.agency.api.local

import com.adammcneilly.spacenerd.core.models.Agency
import kotlinx.coroutines.flow.Flow

/**
 * This is a data source that requests agency information from a local data source.
 *
 * All functions should return a [Flow] that emits any time the local data source changes.
 * Any functions to save data should be suspending and operate on a background thread.
 */
interface LocalAgencyService {
    suspend fun saveAgency(
        agency: Agency,
    )

    fun getAgency(
        id: String,
    ): Flow<Agency>
}
