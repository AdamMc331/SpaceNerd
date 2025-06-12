package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.adammcneilly.spacenerd.shared.core.models.LaunchServiceProvider
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDLaunchServiceProviderDTO(
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "type")
    val type: TSDTypeDTO? = null,
    @Json(name = "url")
    val url: String? = null,
) {
    fun toLaunchServiceProvider(): LaunchServiceProvider {
        return LaunchServiceProvider(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            abbreviation = this.abbrev.orEmpty(),
        )
    }
}
