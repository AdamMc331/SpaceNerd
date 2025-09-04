package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDSocialMediaLinkDTO(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("social_media")
    val socialMedia: TSDSocialMediaDTO? = null,
    @SerialName("url")
    val url: String? = null,
)
