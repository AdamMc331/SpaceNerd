package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Rocket
import kotlinx.datetime.LocalDate

data class RoomRocketDetailDTO(
    @Embedded val rocket: RoomRocketDTO,
    @Relation(
        parentColumn = "manufacturerId",
        entityColumn = "agencyId",
    )
    val manufacturer: RoomAgencyDTO?,
) {
    fun toRocket(): Rocket {
        return Rocket(
            id = rocket.rocketId,
            name = rocket.name,
            imageUrl = rocket.imageUrl,
            manufacturer = manufacturer?.toAgency(),
            description = rocket.description,
            maidenFlight = rocket.maidenFlight?.let { maidenFlight ->
                LocalDate.parse(maidenFlight)
            },
            totalLaunches = rocket.totalLaunches,
        )
    }
}
