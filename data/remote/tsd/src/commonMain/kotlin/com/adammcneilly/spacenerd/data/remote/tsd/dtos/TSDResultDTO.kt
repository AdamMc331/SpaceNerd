package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDResultDTO(
    @SerialName("active_expeditions")
    val activeExpeditions: List<TSDActiveExpeditionDTO>? = null,
    @SerialName("deorbited")
    val deorbited: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("founded")
    val founded: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("orbit")
    val orbit: String? = null,
    @SerialName("owners")
    val owners: List<TSDOwnerDTO>? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("status")
    val status: TSDStatusDTO? = null,
    @SerialName("type")
    val type: TSDTypeDTO? = null,
    @SerialName("url")
    val url: String? = null,
)
