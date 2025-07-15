package com.adammcneilly.spacenerd.data.remote.snapi.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SNAPIEventDTO(
    @SerialName(value = "event_id")
    val eventId: String? = null,
    @SerialName(value = "provider")
    val provider: String? = null,
)
