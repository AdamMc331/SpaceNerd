package com.adammcneilly.spacenerd.data.remote.tsd.dtos

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
)
