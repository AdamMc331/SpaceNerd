package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.CrewMember
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDCrewMemberDTO(
    @SerialName("astronaut")
    val astronaut: TSDAstronautDTO? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("role")
    val role: TSDRoleDTO? = null,
) {
    // NOTE: Remove the force unwraps here
    fun toCrewMember(): CrewMember {
        return CrewMember(
            id = this.id.toString(),
            role = this.role!!.toAstronautRole(),
            astronaut = this.astronaut!!.toAstronaut(),
        )
    }
}
