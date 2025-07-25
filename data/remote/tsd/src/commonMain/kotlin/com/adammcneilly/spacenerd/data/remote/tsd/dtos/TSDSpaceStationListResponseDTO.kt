package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDSpaceStationListResponseDTO(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("next")
    val next: String? = null,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<TSDSpaceStationDTO>? = null,
)
