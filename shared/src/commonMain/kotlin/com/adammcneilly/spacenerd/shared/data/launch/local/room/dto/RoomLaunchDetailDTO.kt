package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.agency.local.room.dto.RoomAgencyDTO
import com.adammcneilly.spacenerd.shared.data.mission.local.room.RoomMissionDTO
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
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
    @Relation(
        parentColumn = "launchMissionId",
        entityColumn = "id",
    )
    val mission: RoomMissionDTO?,
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
        )
    }
}
