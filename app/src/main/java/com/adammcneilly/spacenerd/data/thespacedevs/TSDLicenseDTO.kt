package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDLicenseDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "link")
    val link: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "priority")
    val priority: Int? = null,
)
