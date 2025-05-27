package com.adammcneilly.spacenerd.data.thespacedevs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDMissionDTO(
    @Json(name = "agencies")
    val agencies: List<TSDAgencyDTO>? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "info_urls")
    val infoUrls: List<String>? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "orbit")
    val orbit: TSDOrbitDTO? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "vid_urls")
    val vidUrls: List<String>? = null,
)
