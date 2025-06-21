package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.shared.core.models.Launch
import kotlinx.datetime.Instant

data class RoomLaunchDetailDTO(
    @Embedded val launch: RoomLaunchDTO,
    @Relation(
        parentColumn = "launchAgencyId",
        entityColumn = "id",
    )
    val agency: RoomAgencyDTO?,
    @Relation(
        parentColumn = "launchPadId",
        entityColumn = "id",
    )
    val launchPad: RoomLaunchPadDTO?,
) {
    fun toLaunch(): Launch {
        return Launch(
            id = launch.id,
            name = launch.name,
            imageUrl = launch.imageUrl,
            launchTime = Instant.parse(launch.launchTime),
            status = launch.status,
            agency = agency?.toAgency(),
            pad = launchPad?.toLaunchPad(),
        )
    }
}
