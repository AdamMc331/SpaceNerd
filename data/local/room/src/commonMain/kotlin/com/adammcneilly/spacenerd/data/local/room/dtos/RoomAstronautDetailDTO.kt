package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Astronaut

data class RoomAstronautDetailDTO(
    @Embedded val astronaut: RoomAstronautDTO,
    @Relation(
        parentColumn = "agencyId",
        entityColumn = "agencyId",
        entity = RoomAgencyDTO::class,
    )
    val agency: RoomAgencyDetailDTO?,
) {
    fun toAstronaut(): Astronaut {
        return Astronaut(
            id = astronaut.astronautId,
            name = astronaut.name,
            bio = astronaut.bio,
            imageUrl = astronaut.imageUrl,
            agency = agency?.toAgency(),
        )
    }
}
