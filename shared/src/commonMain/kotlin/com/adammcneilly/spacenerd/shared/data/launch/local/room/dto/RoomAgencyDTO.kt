package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.shared.core.models.Agency

@Entity(tableName = "agencies")
data class RoomAgencyDTO(
    @PrimaryKey val id: String,
    val name: String,
    val abbreviation: String,
) {
    constructor(
        agency: Agency,
    ) : this(
        id = agency.id,
        name = agency.name,
        abbreviation = agency.abbreviation,
    )

    fun toAgency(): Agency {
        return Agency(
            id = id,
            name = name,
            abbreviation = abbreviation,
        )
    }
}
