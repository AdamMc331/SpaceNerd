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
    )
    val agency: RoomAgencyDTO?,
    @Relation(
        parentColumn = "launchPadId",
        entityColumn = "launchPadId",
    )
    val launchPad: RoomLaunchPadDTO?,
    @Relation(
        parentColumn = "launchMissionId",
        entityColumn = "missionId",
    )
    val mission: RoomMissionDTO?,
    @Relation(
        entity = RoomLaunchCrewMemberDTO::class,
        parentColumn = "launchId",
        entityColumn = "launchId",
    )
    val crew: List<RoomLaunchCrewMemberDetailDTO>,
) {
    fun toLaunch(): Launch {
        return Launch(
            id = launch.launchId,
            name = launch.name,
            imageUrl = launch.imageUrl,
            launchTime = Instant.parse(launch.launchTime),
            status = launch.status,
            agency = agency?.toAgency(),
            pad = launchPad?.toLaunchPad(),
            mission = mission?.toMission(),
            crew = crew.map(RoomLaunchCrewMemberDetailDTO::toLaunchCrewMember),
        ).also {
            println("ADAMLOG - CREW: ${it.crew}")
        }
    }
}
