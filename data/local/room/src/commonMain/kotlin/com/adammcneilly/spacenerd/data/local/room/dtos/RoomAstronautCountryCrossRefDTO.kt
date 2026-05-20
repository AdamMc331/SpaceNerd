package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    primaryKeys = [
        "astronautId",
        "countryId",
    ],
)
data class RoomAstronautCountryCrossRefDTO(
    val astronautId: String,
    val countryId: String,
)
