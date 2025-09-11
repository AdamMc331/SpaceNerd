package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation

data class RoomExpeditionWithCrewDTO(
    @Embedded val expedition: RoomExpeditionDTO,
    @Relation(
        parentColumn = "expeditionId",
        entityColumn = "expeditionId",
    )
    val crew: List<RoomCrewMemberDTO>,
)
