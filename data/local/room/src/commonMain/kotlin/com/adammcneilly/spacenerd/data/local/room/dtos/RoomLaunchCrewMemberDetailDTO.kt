package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.LaunchCrewMember
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
data class RoomLaunchCrewMemberDetailDTO(
    @Embedded val launchCrewMember: RoomLaunchCrewMemberDTO,
    @Relation(
        parentColumn = "astronautRoleId",
        entityColumn = "astronautRoleId",
    )
    val astronautRoleDTO: RoomAstronautRoleDTO,
    @Relation(
        parentColumn = "astronautId",
        entityColumn = "astronautId",
    )
    val astronaut: RoomAstronautDTO,
) {
    fun toLaunchCrewMember(): LaunchCrewMember {
        return LaunchCrewMember(
            id = this.launchCrewMember.launchCrewMemberId,
            role = this.astronautRoleDTO.toAstronautRole(),
            astronaut = this.astronaut.toAstronaut(),
        )
    }
}
