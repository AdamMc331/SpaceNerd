package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDConfigurationDTO(
    @SerialName(value = "families")
    val families: List<TSDFamilyDTO?>? = null,
    @SerialName(value = "full_name")
    val fullName: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "variant")
    val variant: String? = null,
)
