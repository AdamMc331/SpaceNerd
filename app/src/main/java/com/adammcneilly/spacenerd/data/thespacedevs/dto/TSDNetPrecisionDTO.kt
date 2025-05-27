package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDNetPrecisionDTO(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "name")
    val name: String? = null,
)
