package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.adammcneilly.spacenerd.core.models.Rocket
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomRocketDTO

@Dao
interface BaseRocketDao : BaseAgencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreRocket(
        rocket: RoomRocketDTO,
    )

    @Transaction
    suspend fun insertDomainRocket(
        rocket: Rocket,
    ) {
        val manufacturer = rocket.manufacturer
        if (manufacturer != null) {
            upsertDomainAgency(manufacturer)
        }

        val rocketDto = RoomRocketDTO(rocket)
        insertOrIgnoreRocket(rocketDto)
    }
}
