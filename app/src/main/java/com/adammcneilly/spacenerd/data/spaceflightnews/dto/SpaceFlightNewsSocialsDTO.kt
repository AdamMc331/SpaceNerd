package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsSocialsDTO(
    @Json(name = "bluesky")
    val bluesky: String? = null,
    @Json(name = "instagram")
    val instagram: String? = null,
    @Json(name = "linkedin")
    val linkedIn: String? = null,
    @Json(name = "mastodon")
    val mastodon: String? = null,
    @Json(name = "x")
    val x: String? = null,
    @Json(name = "youtube")
    val youtube: String? = null,
)
