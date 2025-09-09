package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Mission

@Entity(tableName = "missions")
data class RoomMissionDTO(
    @PrimaryKey val missionId: String,
    val name: String,
    val description: String,
    val imageUrl: String,
) {
    constructor(
        mission: Mission,
    ) : this(
        missionId = mission.id,
        name = mission.name,
        description = mission.description,
        imageUrl = mission.imageUrl,
    )

    fun toMission(): Mission {
        return Mission(
            id = this.missionId,
            name = this.name,
            description = this.description,
            imageUrl = this.imageUrl,
        )
    }
}
