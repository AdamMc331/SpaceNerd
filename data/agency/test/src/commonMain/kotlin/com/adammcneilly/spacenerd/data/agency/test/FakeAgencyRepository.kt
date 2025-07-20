package com.adammcneilly.spacenerd.data.agency.test

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.data.agency.api.AgencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeAgencyRepository : AgencyRepository {
    val agencyById: MutableMap<String, Agency> = mutableMapOf()

    override fun getAgency(
        id: String,
    ): Flow<Agency> {
        return flowOf(agencyById[id]!!)
    }
}
