package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDSpacecraftDTO(
    @SerialName("description")
    val description: String? = null,
    @SerialName("fastest_turnaround")
    val fastestTurnaround: String? = null,
    @SerialName("flights_count")
    val flightsCount: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("in_space")
    val inSpace: Boolean? = null,
    @SerialName("is_placeholder")
    val isPlaceholder: Boolean? = null,
    @SerialName("mission_ends_count")
    val missionEndsCount: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("serial_number")
    val serialNumber: String? = null,
    @SerialName("spacecraft_config")
    val spacecraftConfig: TSDSpacecraftConfigDTO? = null,
    @SerialName("status")
    val status: TSDStatusDTO? = null,
    @SerialName("time_docked")
    val timeDocked: String? = null,
    @SerialName("time_in_space")
    val timeInSpace: String? = null,
    @SerialName("url")
    val url: String? = null,
)
