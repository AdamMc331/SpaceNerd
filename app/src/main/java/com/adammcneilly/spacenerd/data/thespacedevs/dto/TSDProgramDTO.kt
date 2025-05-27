package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDProgramDTO(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
)
