package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.LaunchCrewMember

@Entity(tableName = "launch_crew_members")
data class RoomLaunchCrewMemberDTO(
    @PrimaryKey val launchCrewMemberId: String,
    val launchId: String,
    val astronautRoleId: String,
    val astronautId: String,
) {
    constructor(
        launchCrewMember: LaunchCrewMember,
        launchId: String,
    ) : this(
        launchCrewMemberId = launchCrewMember.id,
        launchId = launchId,
        astronautRoleId = launchCrewMember.role.id,
        astronautId = launchCrewMember.astronaut.id,
    )
}
