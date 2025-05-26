package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsEventDTO(
    @Json(name = "event_id")
    val eventId: String? = null,
    @Json(name = "provider")
    val provider: String? = null,
)
