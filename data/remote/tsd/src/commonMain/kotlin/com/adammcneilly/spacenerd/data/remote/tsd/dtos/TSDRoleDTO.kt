package com.adammcneilly.spacenerd.data.remote.tsd.dtos

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
)
