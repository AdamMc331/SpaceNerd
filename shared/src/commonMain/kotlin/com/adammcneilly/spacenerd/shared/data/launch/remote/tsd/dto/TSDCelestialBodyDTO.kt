package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDCelestialBodyDTO(
    @SerialName(value = "atmosphere")
    val atmosphere: Boolean? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "diameter")
    val diameter: Double? = null,
    @SerialName(value = "failed_landings")
    val failedLandings: Int? = null,
    @SerialName(value = "failed_launches")
    val failedLaunches: Int? = null,
    @SerialName(value = "gravity")
    val gravity: Double? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "length_of_day")
    val lengthOfDay: String? = null,
    @SerialName(value = "mass")
    val mass: Double? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "successful_landings")
    val successfulLandings: Int? = null,
    @SerialName(value = "successful_launches")
    val successfulLaunches: Int? = null,
    @SerialName(value = "total_attempted_landings")
    val totalAttemptedLandings: Int? = null,
    @SerialName(value = "total_attempted_launches")
    val totalAttemptedLaunches: Int? = null,
    @SerialName(value = "type")
    val type: TSDTypeDTO? = null,
    @SerialName(value = "wiki_url")
    val wikiUrl: String? = null,
)
