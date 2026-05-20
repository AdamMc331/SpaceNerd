package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautCountryCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautRoleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCountryDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCrewMemberDTO

@Dao
interface BaseAstronautDao :
    BaseAgencyDao,
    BaseCountryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAstronautCountryCrossRef(
        crossRef: RoomAstronautCountryCrossRefDTO,
    )

    @Upsert
    suspend fun upsertAstronautRole(
        role: RoomAstronautRoleDTO,
    )

    @Upsert
    suspend fun upsertAstronaut(
        astronaut: RoomAstronautDTO,
    )

    @Transaction
    suspend fun upsertDomainAstronaut(
        astronaut: Astronaut,
    ) {
        val roomAstronaut = RoomAstronautDTO(astronaut)
        upsertAstronaut(roomAstronaut)

        val agency = astronaut.agency
        if (agency != null) {
            upsertDomainAgency(agency)
        }

        for (country in astronaut.nationalities) {
            val countryDto = RoomCountryDTO(country)
            insertOrIgnoreCountry(countryDto)

            val crossRef = RoomAstronautCountryCrossRefDTO(
                astronautId = astronaut.id,
                countryId = country.id,
            )

            insertOrIgnoreAstronautCountryCrossRef(crossRef)
        }
    }
}
