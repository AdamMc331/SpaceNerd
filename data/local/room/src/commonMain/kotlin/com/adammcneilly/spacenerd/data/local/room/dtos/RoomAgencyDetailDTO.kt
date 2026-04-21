package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Agency

data class RoomAgencyDetailDTO(
    @Embedded val agency: RoomAgencyDTO,
    @Relation(
        parentColumn = "agencyId",
        entityColumn = "countryId",
        associateBy = Junction(
            value = RoomAgencyCountryCrossRefDTO::class,
            parentColumn = "agency_id",
            entityColumn = "country_id",
        ),
    )
    val countries: List<RoomCountryDTO>,
) {
    fun toAgency(): Agency {
        return agency.toAgency().copy(
            countries = countries.map(RoomCountryDTO::toCountry),
        )
    }
}
