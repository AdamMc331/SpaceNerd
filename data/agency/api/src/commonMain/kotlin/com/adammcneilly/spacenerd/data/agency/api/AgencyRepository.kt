package com.adammcneilly.spacenerd.data.agency.api

import com.adammcneilly.spacenerd.core.models.Agency
import kotlinx.coroutines.flow.Flow

/**
 * Defines any data requests to retrieve agency information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
interface AgencyRepository {
    fun getAgency(
        id: String,
    ): Flow<Agency>
}
