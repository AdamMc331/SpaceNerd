package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDNetPrecisionDTO(
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "abbrev")
    val abbrev: String? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
)
