package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Astronaut

@Entity(tableName = "astronauts")
data class RoomAstronautDTO(
    @PrimaryKey val astronautId: String,
    val name: String,
    val imageUrl: String,
) {

    constructor(
        astronaut: Astronaut,
    ): this(
        astronautId = astronaut.id,
        name = astronaut.name,
        imageUrl = astronaut.imageUrl,
    )

    fun toAstronaut(): Astronaut {
        return Astronaut(
            id = astronautId,
            name = name,
            imageUrl = imageUrl,
        )
    }
}
