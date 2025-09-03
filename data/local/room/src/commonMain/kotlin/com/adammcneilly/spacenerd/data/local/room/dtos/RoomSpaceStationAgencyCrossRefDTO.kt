package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity

@Entity(
    primaryKeys = [
        "spaceStationId",
        "agencyId",
    ],
)
data class RoomSpaceStationAgencyCrossRefDTO(
    val spaceStationId: String,
    val agencyId: String,
)
