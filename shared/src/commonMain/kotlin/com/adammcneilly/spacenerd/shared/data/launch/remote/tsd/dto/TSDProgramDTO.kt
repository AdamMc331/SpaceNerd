package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDProgramDTO(
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
)
