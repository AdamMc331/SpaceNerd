package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDConfigurationDTO(
    @Json(name = "families")
    val families: List<TSDFamilyDTO?>? = null,
    @Json(name = "full_name")
    val fullName: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "variant")
    val variant: String? = null,
)
