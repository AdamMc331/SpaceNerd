package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCountryDTO

@Dao
interface BaseCountryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCountry(
        country: RoomCountryDTO,
    )
}
