package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDProgramDTO(
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
)
