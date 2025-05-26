package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsAuthorDTO(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "socials")
    val socials: SpaceFlightNewsSocialsDTO? = null,
)
