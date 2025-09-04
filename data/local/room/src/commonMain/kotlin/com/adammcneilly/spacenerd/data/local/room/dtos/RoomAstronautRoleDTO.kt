package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.AstronautRole

@Entity(tableName = "astronaut_roles")
data class RoomAstronautRoleDTO(
    @PrimaryKey val astronautRoleId: String,
    val name: String,
    val priority: Int,
) {

    constructor(
        role: AstronautRole,
    ): this(
        astronautRoleId = role.id,
        name = role.name,
        priority = role.priority,
    )

    fun toAstronautRole(): AstronautRole {
        return AstronautRole(
            id = astronautRoleId,
            name = name,
            priority = priority,
        )
    }
}
