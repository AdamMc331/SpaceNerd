package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.CrewMember
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
data class RoomCrewMemberDetailDTO(
    @Embedded val crewMember: RoomCrewMemberDTO,
    @Relation(
        parentColumn = "astronautRoleId",
        entityColumn = "astronautRoleId",
    )
    val astronautRoleDTO: RoomAstronautRoleDTO,
    @Relation(
        parentColumn = "astronautId",
        entityColumn = "astronautId",
        entity = RoomAstronautDTO::class,
    )
    val astronaut: RoomAstronautDetailDTO,
) {
    fun toCrewMember(): CrewMember {
        return CrewMember(
            id = this.crewMember.crewMemberId,
            role = this.astronautRoleDTO.toAstronautRole(),
            astronaut = this.astronaut.toAstronaut(),
        )
    }
}
