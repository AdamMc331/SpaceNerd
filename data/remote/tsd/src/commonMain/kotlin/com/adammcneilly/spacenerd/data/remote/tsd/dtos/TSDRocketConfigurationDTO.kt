package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.Rocket
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDRocketConfigurationDTO(
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "families")
    val families: List<TSDFamilyDTO?>? = null,
    @SerialName(value = "full_name")
    val fullName: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "maiden_flight")
    val maidenFlight: String? = null,
    @SerialName(value = "manufacturer")
    val manufacturer: TSDAgencyDTO? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "total_launch_count")
    val totalLaunchCount: Int? = null,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "variant")
    val variant: String? = null,
) {
    fun toRocket(): Rocket {
        return Rocket(
            id = id.toString(),
            imageUrl = image?.imageUrl.orEmpty(),
            manufacturer = manufacturer?.toAgency(),
            description = description.orEmpty(),
            maidenFlight = maidenFlight?.let { maidenFlight ->
                LocalDate.parse(maidenFlight)
            },
            name = name.orEmpty(),
            totalLaunches = totalLaunchCount ?: 0,
        )
    }
}
