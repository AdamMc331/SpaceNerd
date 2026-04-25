package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Country
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyCountryCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCountryDTO

/**
 * This is a base interface that inserts an [Agency] object into our Room database
 * along with any [com.adammcneilly.spacenerd.core.models.Country] dependencies.
 */
@Dao
interface BaseAgencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCountry(
        country: RoomCountryDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAgencyCountryCrossRef(
        crossRef: RoomAgencyCountryCrossRefDTO,
    )

    @Upsert
    suspend fun upsertAgency(
        agency: RoomAgencyDTO,
    )

    private suspend fun insertAgencyCountry(
        country: Country,
        agencyId: String,
    ) {
        val countryDto = RoomCountryDTO(country)
        insertOrIgnoreCountry(countryDto)

        val crossRef = RoomAgencyCountryCrossRefDTO(
            agencyId = agencyId,
            countryId = country.id,
        )

        insertOrIgnoreAgencyCountryCrossRef(crossRef)
    }

    @Transaction
    suspend fun upsertDomainAgency(
        agency: Agency,
    ) {
        for (country in agency.countries) {
            insertAgencyCountry(
                country = country,
                agencyId = agency.id,
            )
        }

        val agencyDto = RoomAgencyDTO(agency)
        upsertAgency(agencyDto)
    }
}
