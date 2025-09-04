package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDSocialMediaDTO(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("logo")
    val logo: TSDLogoDTO? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("url")
    val url: String? = null,
)
