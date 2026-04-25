package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCountryDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the agencies table.
 */
@Dao
interface RoomAgencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCountry(
        country: RoomCountryDTO,
    )

    @Upsert
    suspend fun upsertAgency(
        agency: RoomAgencyDTO,
    )

    @Transaction
    suspend fun upsertAgency(
        agency: Agency,
    ) {
        for (country in agency.countries) {
            val countryDto = RoomCountryDTO(country)
            insertOrIgnoreCountry(countryDto)
        }

        val agencyDto = RoomAgencyDTO(agency)
        upsertAgency(agencyDto)
    }

    @Query(
        """
        SELECT * 
        FROM agencies 
        WHERE agencyId = :id
        """,
    )
    fun getAgency(
        id: String,
    ): Flow<RoomAgencyDTO>
}
