package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.adammcneilly.spacenerd.core.models.Author
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsAuthorDTO(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "socials")
    val socials: SpaceFlightNewsSocialsDTO? = null,
) {
    fun toAuthor(): Author {
        return Author(
            name = this.name.orEmpty(),
        )
    }
}
