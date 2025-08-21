package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import kotlinx.datetime.LocalDate
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Entity(tableName = "space_stations")
data class RoomSpaceStationDTO(
    @PrimaryKey val id: String,
    val name: String,
    val status: SpaceStationStatus,
    val imageUrl: String,
    val founded: String,
) {
    constructor(
        spaceStation: SpaceStation,
    ) : this(
        id = spaceStation.id,
        name = spaceStation.name,
        status = spaceStation.status,
        imageUrl = spaceStation.imageUrl,
        founded = spaceStation.founded.toString(),
    )

    fun toSpaceStation(): SpaceStation {
        return SpaceStation(
            id = id,
            name = name,
            status = status,
            imageUrl = imageUrl,
            agencies = emptyList(), // Follow up to store agencies in Room.
            founded = LocalDate.parse(this.founded),
        )
    }
}
