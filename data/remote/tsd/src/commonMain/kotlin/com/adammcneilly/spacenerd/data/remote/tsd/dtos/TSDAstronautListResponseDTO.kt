package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDAstronautListResponseDTO(
    @SerialName(value = "count")
    val count: Int? = null,
    @SerialName(value = "next")
    val next: String? = null,
    @SerialName(value = "previous")
    val previous: String? = null,
    @SerialName(value = "results")
    val results: List<TSDAstronautDTO>? = null,
)
