package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.CrewMember

@Entity(tableName = "crew_members")
data class RoomCrewMemberDTO(
    @PrimaryKey val crewMemberId: String,
    val astronautRoleId: String,
    val astronautId: String,
    val expeditionId: String?,
) {
    constructor(
        crewMember: CrewMember,
        expeditionId: String,
    ) : this(
        crewMemberId = crewMember.id,
        astronautRoleId = crewMember.role.id,
        astronautId = crewMember.astronaut.id,
        expeditionId = expeditionId,
    )
}
