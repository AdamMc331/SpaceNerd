package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.AstronautRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDRoleDTO(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("priority")
    val priority: Int? = null,
    @SerialName("role")
    val role: String? = null,
) {
    fun toAstronautRole(): AstronautRole {
        return AstronautRole(
            id = this.id.toString(),
            name = this.role.orEmpty(),
            priority = this.priority ?: -1,
        )
    }
}
