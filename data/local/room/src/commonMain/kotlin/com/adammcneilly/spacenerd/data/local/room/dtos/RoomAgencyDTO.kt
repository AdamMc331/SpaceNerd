package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Agency

@Entity(tableName = "agencies")
data class RoomAgencyDTO(
    @PrimaryKey val agencyId: String,
    val name: String,
    val abbreviation: String,
    val description: String,
    val logoUrl: String,
) {
    constructor(
        agency: Agency,
    ) : this(
        agencyId = agency.id,
        name = agency.name,
        abbreviation = agency.abbreviation,
        description = agency.description,
        logoUrl = agency.logoUrl,
    )

    fun toAgency(): Agency {
        return Agency(
            id = agencyId,
            name = name,
            abbreviation = abbreviation,
            description = description,
            logoUrl = logoUrl,
        )
    }
}
