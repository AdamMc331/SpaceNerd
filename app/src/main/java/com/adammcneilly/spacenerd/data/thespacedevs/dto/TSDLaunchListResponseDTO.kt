package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDLaunchListResponseDTO(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "next")
    val next: String? = null,
    @Json(name = "previous")
    val previous: String? = null,
    @Json(name = "results")
    val results: List<TSDLaunchDTO>? = null,
)
