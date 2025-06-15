package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import com.adammcneilly.spacenerd.shared.core.models.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLocationDTO(
    @SerialName(value = "active")
    val active: Boolean? = null,
    @SerialName(value = "celestial_body")
    val celestialBody: TSDCelestialBodyDTO? = null,
    @SerialName(value = "country")
    val country: TSDCountryDTO? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "latitude")
    val latitude: Double? = null,
    @SerialName(value = "longitude")
    val longitude: Double? = null,
    @SerialName(value = "map_image")
    val mapImage: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "timezone_name")
    val timezoneName: String? = null,
    @SerialName(value = "total_landing_count")
    val totalLandingCount: Int? = null,
    @SerialName(value = "total_launch_count")
    val totalLaunchCount: Int? = null,
    @SerialName(value = "url")
    val url: String? = null,
) {
    fun toLocation(): Location {
        return Location(
            id = this.id.toString(),
            name = this.name.orEmpty(),
        )
    }
}
