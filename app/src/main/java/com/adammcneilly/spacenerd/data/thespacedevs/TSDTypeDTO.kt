package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDTypeDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
)
