package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.adammcneilly.spacenerd.shared.core.models.Location
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDLocationDTO(
    @Json(name = "active")
    val active: Boolean? = null,
    @Json(name = "celestial_body")
    val celestialBody: TSDCelestialBodyDTO? = null,
    @Json(name = "country")
    val country: TSDCountryDTO? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image")
    val image: TSDImageDTO? = null,
    @Json(name = "latitude")
    val latitude: Double? = null,
    @Json(name = "longitude")
    val longitude: Double? = null,
    @Json(name = "map_image")
    val mapImage: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "timezone_name")
    val timezoneName: String? = null,
    @Json(name = "total_landing_count")
    val totalLandingCount: Int? = null,
    @Json(name = "total_launch_count")
    val totalLaunchCount: Int? = null,
    @Json(name = "url")
    val url: String? = null,
) {
    fun toLocation(): Location {
        return Location(
            id = this.id.toString(),
            name = this.name.orEmpty(),
        )
    }
}
