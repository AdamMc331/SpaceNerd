package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsLaunchDTO(
    @Json(name = "launch_id")
    val launchId: String? = null,
    @Json(name = "provider")
    val provider: String? = null,
)
