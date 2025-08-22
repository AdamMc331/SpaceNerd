package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDParentDTO(
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("maiden_flight")
    val maidenFlight: String? = null,
    @SerialName("manufacturer")
    val manufacturer: TSDAgencyDTO? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("parent")
    val parent: String? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
)
