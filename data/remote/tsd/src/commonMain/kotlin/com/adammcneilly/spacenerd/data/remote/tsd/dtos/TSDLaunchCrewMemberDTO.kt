package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.LaunchCrewMember
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLaunchCrewMemberDTO(
    @SerialName("astronaut")
    val astronaut: TSDAstronautDTO? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("role")
    val role: TSDRoleDTO? = null,
) {
    // NOTE: Remove the force unwraps here
    fun toLaunchCrewMember(): LaunchCrewMember {
        return LaunchCrewMember(
            id = this.id.toString(),
            role = this.role!!.toAstronautRole(),
            astronaut = this.astronaut!!.toAstronaut(),
        )
    }
}
