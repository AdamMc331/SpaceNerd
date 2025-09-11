package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expeditions")
data class RoomExpeditionDTO(
    @PrimaryKey val expeditionId: String,
    val name: String,
    val start: String,
    val end: String?,
    val spaceStationId: String,
)
