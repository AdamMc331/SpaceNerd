package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDImageVariantDTO(
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image_url")
    val imageUrl: String? = null,
    @SerialName(value = "type")
    val type: TSDTypeDTO? = null,
)
