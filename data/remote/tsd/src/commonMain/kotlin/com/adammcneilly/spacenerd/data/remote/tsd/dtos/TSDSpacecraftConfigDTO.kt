package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDSpacecraftConfigDTO(
    @SerialName("agency")
    val agency: TSDAgencyDTO? = null,
    @SerialName("attempted_landings")
    val attemptedLandings: Int? = null,
    @SerialName("capability")
    val capability: String? = null,
    @SerialName("crew_capacity")
    val crewCapacity: Int? = null,
    @SerialName("details")
    val details: String? = null,
    @SerialName("diameter")
    val diameter: Double? = null,
    @SerialName("failed_landings")
    val failedLandings: Int? = null,
    @SerialName("failed_launches")
    val failedLaunches: Int? = null,
    @SerialName("family")
    val family: List<TSDFamilyDTO>? = null,
    @SerialName("fastest_turnaround")
    val fastestTurnaround: String? = null,
    @SerialName("flight_life")
    val flightLife: String? = null,
    @SerialName("height")
    val height: Double? = null,
    @SerialName("history")
    val history: String? = null,
    @SerialName("human_rated")
    val humanRated: Boolean? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("in_use")
    val inUse: Boolean? = null,
    @SerialName("info_link")
    val infoLink: String? = null,
    @SerialName("maiden_flight")
    val maidenFlight: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("payload_capacity")
    val payloadCapacity: Int? = null,
    @SerialName("payload_return_capacity")
    val payloadReturnCapacity: Int? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("spacecraft_flown")
    val spacecraftFlown: Int? = null,
    @SerialName("successful_landings")
    val successfulLandings: Int? = null,
    @SerialName("successful_launches")
    val successfulLaunches: Int? = null,
    @SerialName("total_launch_count")
    val totalLaunchCount: Int? = null,
    @SerialName("type")
    val type: TSDTypeDTO? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("wiki_link")
    val wikiLink: String? = null,
)
