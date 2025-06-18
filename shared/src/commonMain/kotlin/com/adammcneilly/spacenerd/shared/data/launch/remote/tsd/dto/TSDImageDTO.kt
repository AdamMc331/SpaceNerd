package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDImageDTO(
    @SerialName(value = "credit")
    val credit: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image_url")
    val imageUrl: String? = null,
    @SerialName(value = "license")
    val license: TSDLicenseDTO? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "single_use")
    val singleUse: Boolean? = null,
    @SerialName(value = "thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName(value = "variants")
    val variants: List<String>? = null,
)
