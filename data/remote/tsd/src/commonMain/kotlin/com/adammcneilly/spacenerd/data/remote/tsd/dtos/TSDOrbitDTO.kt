package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDOrbitDTO(
    @SerialName(value = "abbrev")
    val abbrev: String? = null,
    @SerialName(value = "celestial_body")
    val celestialBody: TSDCelestialBodyDTO? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
)
