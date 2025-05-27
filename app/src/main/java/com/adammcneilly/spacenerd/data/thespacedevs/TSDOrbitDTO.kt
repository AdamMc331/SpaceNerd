package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDOrbitDTO(
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "celestial_body")
    val celestialBody: TSDCelestialBodyDTO? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
)
