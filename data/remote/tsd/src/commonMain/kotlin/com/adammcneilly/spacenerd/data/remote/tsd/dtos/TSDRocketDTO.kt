package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDRocketDTO(
    @SerialName(value = "configuration")
    val configuration: TSDRocketConfigurationDTO? = null,
    @SerialName(value = "id")
    val id: Int? = null,
)
