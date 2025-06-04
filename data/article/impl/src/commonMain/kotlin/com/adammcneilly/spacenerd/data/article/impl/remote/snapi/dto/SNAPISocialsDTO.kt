package com.adammcneilly.spacenerd.data.article.impl.remote.snapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SNAPISocialsDTO(
    @SerialName(value = "bluesky")
    val bluesky: String? = null,
    @SerialName(value = "instagram")
    val instagram: String? = null,
    @SerialName(value = "linkedin")
    val linkedIn: String? = null,
    @SerialName(value = "mastodon")
    val mastodon: String? = null,
    @SerialName(value = "x")
    val x: String? = null,
    @SerialName(value = "youtube")
    val youtube: String? = null,
)
