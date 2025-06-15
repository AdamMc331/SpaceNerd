package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDRocketDTO(
    @SerialName(value = "configuration")
    val configuration: TSDConfigurationDTO? = null,
    @SerialName(value = "id")
    val id: Int? = null,
)
