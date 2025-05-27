package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDImageDTO(
    @Json(name = "credit")
    val credit: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null,
    @Json(name = "license")
    val license: TSDLicenseDTO? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "single_use")
    val singleUse: Boolean? = null,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = null,
    @Json(name = "variants")
    val variants: List<String>? = null,
)
