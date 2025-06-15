package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLaunchListResponseDTO(
    @SerialName(value = "count")
    val count: Int? = null,
    @SerialName(value = "next")
    val next: String? = null,
    @SerialName(value = "previous")
    val previous: String? = null,
    @SerialName(value = "results")
    val results: List<TSDLaunchDTO>? = null,
)
