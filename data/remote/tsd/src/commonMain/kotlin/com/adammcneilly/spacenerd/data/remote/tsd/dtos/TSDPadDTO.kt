package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.LaunchPad
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDPadDTO(
    @SerialName(value = "active")
    val active: Boolean? = null,
    @SerialName(value = "agencies")
    val agencies: List<TSDAgencyDTO>? = null,
    @SerialName(value = "country")
    val country: TSDCountryDTO? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "fastest_turnaround")
    val fastestTurnaround: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "info_url")
    val infoUrl: String? = null,
    @SerialName(value = "latitude")
    val latitude: Double? = null,
    @SerialName(value = "location")
    val location: TSDLocationDTO? = null,
    @SerialName(value = "longitude")
    val longitude: Double? = null,
    @SerialName(value = "map_image")
    val mapImage: String? = null,
    @SerialName(value = "map_url")
    val mapUrl: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int? = null,
    @SerialName(value = "total_launch_count")
    val totalLaunchCount: Int? = null,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "wiki_url")
    val wikiUrl: String? = null,
) {
    fun toLaunchPad(): LaunchPad {
        return LaunchPad(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            location = this.location?.toLocation(),
        )
    }
}
