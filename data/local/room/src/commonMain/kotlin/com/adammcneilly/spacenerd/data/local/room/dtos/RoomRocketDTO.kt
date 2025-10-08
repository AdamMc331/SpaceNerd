package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Rocket

@Entity(tableName = "rockets")
data class RoomRocketDTO(
    @PrimaryKey val rocketId: String,
    val name: String,
    val imageUrl: String,
    val manufacturerId: String?,
    val description: String,
    val maidenFlight: String?,
    val totalLaunches: Int,
) {
    constructor(
        rocket: Rocket,
    ) : this(
        rocketId = rocket.id,
        name = rocket.name,
        imageUrl = rocket.imageUrl,
        manufacturerId = rocket.manufacturer?.id,
        description = rocket.description,
        maidenFlight = rocket.maidenFlight?.toString(),
        totalLaunches = rocket.totalLaunches,
    )
}
