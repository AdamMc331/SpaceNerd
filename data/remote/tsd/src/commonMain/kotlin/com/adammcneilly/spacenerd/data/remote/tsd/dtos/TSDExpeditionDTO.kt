package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDExpeditionDTO(
    @SerialName("crew")
    val crew: List<TSDCrewMemberDTO>? = null,
    @SerialName("end")
    val end: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("mission_patches")
    val missionPatches: List<TSDMissionPatchesDTO>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("spacestation")
    val spacestation: TSDSpaceStationSummaryDTO? = null,
//    @SerialName("spacewalks")
//    val spacewalks: List<Any?>? = listOf(),
    @SerialName("start")
    val start: String? = null,
    @SerialName("url")
    val url: String? = null,
)
