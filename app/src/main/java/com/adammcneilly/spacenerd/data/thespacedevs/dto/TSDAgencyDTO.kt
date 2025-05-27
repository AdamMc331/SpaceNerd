package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDAgencyDTO(
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "administrator")
    val administrator: String? = null,
    @Json(name = "country")
    val country: List<TSDCountryDTO>? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "featured")
    val featured: Boolean? = null,
    @Json(name = "founding_year")
    val foundingYear: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image")
    val image: TSDImageDTO? = null,
    @Json(name = "launchers")
    val launchers: String? = null,
    @Json(name = "logo")
    val logo: TSDLogoDTO? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "parent")
    val parent: String? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "social_logo")
    val socialLogo: TSDSocialLogoDTO? = null,
    @Json(name = "spacecraft")
    val spacecraft: String? = null,
    @Json(name = "type")
    val type: TSDTypeDTO? = null,
    @Json(name = "url")
    val url: String? = null,
)
