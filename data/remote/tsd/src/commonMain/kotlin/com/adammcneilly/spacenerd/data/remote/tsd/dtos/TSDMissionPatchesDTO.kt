package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDMissionPatchesDTO(
    @SerialName("agency")
    val agency: TSDAgencyDTO? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("priority")
    val priority: Int? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
)
