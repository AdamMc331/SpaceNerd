package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLanguageDTO(
    @SerialName(value = "code")
    val code: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
)
