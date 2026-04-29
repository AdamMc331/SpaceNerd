package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautRoleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCrewMemberDTO

@Dao
interface BaseAstronautDao {
    @Upsert
    suspend fun upsertAstronautRole(
        role: RoomAstronautRoleDTO,
    )

    @Upsert
    suspend fun upsertAstronaut(
        astronaut: RoomAstronautDTO,
    )
}
