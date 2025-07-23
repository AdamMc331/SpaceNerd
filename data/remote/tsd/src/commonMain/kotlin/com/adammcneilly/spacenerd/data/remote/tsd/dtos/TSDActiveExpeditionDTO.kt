package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDActiveExpeditionDTO(
    @SerialName("end")
    val end: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("start")
    val start: String? = null,
    @SerialName("url")
    val url: String? = null,
)
