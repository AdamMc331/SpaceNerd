package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.core.models.AstronautStatus

data class RoomAstronautDetailDTO(
    @Embedded val astronaut: RoomAstronautDTO,
    @Relation(
        parentColumn = "agencyId",
        entityColumn = "agencyId",
        entity = RoomAgencyDTO::class,
    )
    val agency: RoomAgencyDetailDTO?,
    @Relation(
        parentColumn = "astronautId",
        entityColumn = "countryId",
        associateBy = Junction(RoomAstronautCountryCrossRefDTO::class),
    )
    val countries: List<RoomCountryDTO>,
) {
    fun toAstronaut(): Astronaut {
        return Astronaut(
            id = astronaut.astronautId,
            name = astronaut.name,
            bio = astronaut.bio,
            imageUrl = astronaut.imageUrl,
            agency = agency?.toAgency(),
            nationalities = countries.map(RoomCountryDTO::toCountry),
            inSpace = astronaut.inSpace,
            status = AstronautStatus.valueOf(astronaut.status),
        )
    }
}
