package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDAgencyDTO(
    @SerialName(value = "abbrev")
    val abbrev: String? = null,
    @SerialName(value = "administrator")
    val administrator: String? = null,
    @SerialName(value = "country")
    val country: List<TSDCountryDTO>? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "featured")
    val featured: Boolean? = null,
    @SerialName(value = "founding_year")
    val foundingYear: Int? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "launchers")
    val launchers: String? = null,
    @SerialName(value = "logo")
    val logo: TSDLogoDTO? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "parent")
    val parent: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "social_logo")
    val socialLogo: TSDSocialLogoDTO? = null,
    @SerialName(value = "spacecraft")
    val spacecraft: String? = null,
    @SerialName(value = "type")
    val type: TSDTypeDTO? = null,
    @SerialName(value = "url")
    val url: String? = null,
)
