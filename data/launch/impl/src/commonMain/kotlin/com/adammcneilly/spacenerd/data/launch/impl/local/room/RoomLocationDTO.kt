package com.adammcneilly.spacenerd.data.launch.impl.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Location

@Entity(tableName = "locations")
data class RoomLocationDTO(
    @PrimaryKey val id: String,
    val name: String,
) {
    constructor(
        location: Location,
    ) : this(
        id = location.id,
        name = location.name,
    )

    fun toLocation(): Location {
        return Location(
            id = id,
            name = name,
        )
    }
}
