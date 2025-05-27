package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDCountryDTO(
    @Json(name = "alpha_2_code")
    val alpha2Code: String? = null,
    @Json(name = "alpha_3_code")
    val alpha3Code: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "nationality_name")
    val nationalityName: String? = null,
    @Json(name = "nationality_name_composed")
    val nationalityNameComposed: String? = null,
)
