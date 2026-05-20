package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.Astronaut
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDAstronautDTO(
    @SerialName("age")
    val age: Int? = null,
    @SerialName("agency")
    val agency: TSDAgencyDTO? = null,
    @SerialName("bio")
    val bio: String? = null,
    @SerialName("date_of_birth")
    val dateOfBirth: String? = null,
    @SerialName("date_of_death")
    val dateOfDeath: String? = null,
    @SerialName("eva_time")
    val evaTime: String? = null,
    @SerialName("first_flight")
    val firstFlight: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("in_space")
    val inSpace: Boolean? = false,
    @SerialName("last_flight")
    val lastFlight: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("nationality")
    val nationalities: List<TSDCountryDTO>? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("social_media_links")
    val socialMediaLinks: List<TSDSocialMediaLinkDTO>? = null,
    @SerialName("status")
    val status: TSDStatusDTO? = null,
    @SerialName("time_in_space")
    val timeInSpace: String? = null,
    @SerialName("type")
    val type: TSDTypeDTO? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("wiki")
    val wiki: String? = "",
) {
    fun toAstronaut(): Astronaut {
        return Astronaut(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            bio = this.bio.orEmpty(),
            imageUrl = this.image?.imageUrl.orEmpty(),
            agency = this.agency?.toAgency(),
            nationalities = this.nationalities?.map(TSDCountryDTO::toCountry).orEmpty(),
        )
    }
}
