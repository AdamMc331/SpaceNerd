package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchPadDTO

interface RoomLaunchPadDao {
    @Upsert
    suspend fun upsertLaunchPad(
        launchPad: RoomLaunchPadDTO,
    )
}
