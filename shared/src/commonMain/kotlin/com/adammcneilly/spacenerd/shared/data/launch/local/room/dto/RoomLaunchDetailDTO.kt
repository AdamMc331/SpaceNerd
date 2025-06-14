package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.shared.core.models.Launch
import kotlinx.datetime.Instant

data class RoomLaunchDetailDTO(
    @Embedded val launch: RoomLaunchDTO,
    @Relation(
        parentColumn = "launchServiceProviderId",
        entityColumn = "id",
    )
    val launchServiceProvider: RoomLaunchServiceProviderDTO?,
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
            provider = launchServiceProvider?.toLaunchServiceProvider(),
            pad = launchPad?.toLaunchPad(),
        )
    }
}
