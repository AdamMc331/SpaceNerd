package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDLaunchServiceProviderDTO(
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "type")
    val type: TSDTypeDTO? = null,
    @Json(name = "url")
    val url: String? = null,
)
