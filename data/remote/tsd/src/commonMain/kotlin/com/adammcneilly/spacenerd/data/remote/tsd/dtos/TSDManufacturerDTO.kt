package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDManufacturerDTO(
    @SerialName("abbrev")
    val abbrev: String? = null,
    @SerialName("administrator")
    val administrator: String? = null,
    @SerialName("country")
    val country: List<TSDCountryDTO>? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("featured")
    val featured: Boolean? = null,
    @SerialName("founding_year")
    val foundingYear: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("launchers")
    val launchers: String? = null,
    @SerialName("logo")
    val logo: TSDLogoDTO? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("parent")
    val parent: String? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("social_logo")
    val socialLogo: TSDSocialLogoDTO? = null,
    @SerialName("spacecraft")
    val spacecraft: String? = null,
    @SerialName("type")
    val type: TSDTypeDTO? = null,
    @SerialName("url")
    val url: String? = null,
)
