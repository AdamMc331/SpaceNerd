package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Launch
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class RoomLaunchDetailDTO(
    @Embedded val launch: RoomLaunchDTO,
    @Relation(
        parentColumn = "launchAgencyId",
        entityColumn = "agencyId",
        entity = RoomAgencyDTO::class,
    )
    val agency: RoomAgencyDetailDTO?,
    @Relation(
        parentColumn = "launchPadId",
        entityColumn = "id",
    )
    val launchPad: RoomLaunchPadDTO?,
    @Relation(
        parentColumn = "launchMissionId",
        entityColumn = "id",
    )
    val mission: RoomMissionDTO?,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "rocketId",
        entity = RoomRocketDTO::class,
    )
    val rocket: RoomRocketDetailDTO?,
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
            mission = mission?.toMission(),
            rocket = rocket?.toRocket(),
        )
    }
}
