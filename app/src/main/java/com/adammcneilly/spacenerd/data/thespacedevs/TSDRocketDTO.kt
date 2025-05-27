package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDRocketDTO(
    @Json(name = "configuration")
    val configuration: TSDConfigurationDTO? = null,
    @Json(name = "id")
    val id: Int? = null,
)
