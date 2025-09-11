package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Expedition
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(tableName = "expeditions")
data class RoomExpeditionDTO(
    @PrimaryKey val expeditionId: String,
    val name: String,
    val expeditionStart: String,
    val expeditionEnd: String?,
    val spaceStationId: String?,
) {
    constructor(
        expedition: Expedition,
    ) : this(
        expeditionId = expedition.id,
        name = expedition.name,
        expeditionStart = expedition.start.toString(),
        expeditionEnd = expedition.end?.toString(),
        spaceStationId = expedition.spaceStation?.id,
    )
}
