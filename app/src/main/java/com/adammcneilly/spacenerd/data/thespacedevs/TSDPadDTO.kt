package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDPadDTO(
    @Json(name = "active")
    val active: Boolean? = null,
    @Json(name = "agencies")
    val agencies: List<TSDAgencyDTO>? = null,
    @Json(name = "country")
    val country: TSDCountryDTO? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "fastest_turnaround")
    val fastestTurnaround: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "info_url")
    val infoUrl: String? = null,
    @Json(name = "latitude")
    val latitude: Double? = null,
    @Json(name = "location")
    val location: TSDLocationDTO? = null,
    @Json(name = "longitude")
    val longitude: Double? = null,
    @Json(name = "map_image")
    val mapImage: String? = null,
    @Json(name = "map_url")
    val mapUrl: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int? = null,
    @Json(name = "total_launch_count")
    val totalLaunchCount: Int? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "wiki_url")
    val wikiUrl: String? = null,
)
