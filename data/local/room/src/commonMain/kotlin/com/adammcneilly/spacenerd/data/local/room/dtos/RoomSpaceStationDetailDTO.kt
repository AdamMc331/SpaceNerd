package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.SpaceStation

data class RoomSpaceStationDetailDTO(
    @Embedded val station: RoomSpaceStationDTO,
    @Relation(
        parentColumn = "spaceStationId",
        entityColumn = "agencyId",
        associateBy = Junction(RoomSpaceStationAgencyCrossRefDTO::class),
    )
    val agencies: List<RoomAgencyDTO>,
) {
    fun toSpaceStation(): SpaceStation {
        return station.toSpaceStation().copy(
            agencies = agencies.map(RoomAgencyDTO::toAgency),
        )
    }
}
