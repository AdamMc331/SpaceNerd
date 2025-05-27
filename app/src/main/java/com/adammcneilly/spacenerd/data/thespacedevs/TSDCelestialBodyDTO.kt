package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDCelestialBodyDTO(
    @Json(name = "atmosphere")
    val atmosphere: Boolean? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "diameter")
    val diameter: Double? = null,
    @Json(name = "failed_landings")
    val failedLandings: Int? = null,
    @Json(name = "failed_launches")
    val failedLaunches: Int? = null,
    @Json(name = "gravity")
    val gravity: Double? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image")
    val image: TSDImageDTO? = null,
    @Json(name = "length_of_day")
    val lengthOfDay: String? = null,
    @Json(name = "mass")
    val mass: Double? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "successful_landings")
    val successfulLandings: Int? = null,
    @Json(name = "successful_launches")
    val successfulLaunches: Int? = null,
    @Json(name = "total_attempted_landings")
    val totalAttemptedLandings: Int? = null,
    @Json(name = "total_attempted_launches")
    val totalAttemptedLaunches: Int? = null,
    @Json(name = "type")
    val type: TSDTypeDTO? = null,
    @Json(name = "wiki_url")
    val wikiUrl: String? = null,
)
