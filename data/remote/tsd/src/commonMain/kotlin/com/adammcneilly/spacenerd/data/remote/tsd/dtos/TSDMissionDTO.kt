package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.Mission
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDMissionDTO(
    @SerialName(value = "agencies")
    val agencies: List<TSDAgencyDTO>? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: String? = null,
    @SerialName(value = "info_urls")
    val infoUrls: List<TSDInfoUrlDTO>? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "orbit")
    val orbit: TSDOrbitDTO? = null,
    @SerialName(value = "type")
    val type: String? = null,
    @SerialName(value = "vid_urls")
    val vidUrls: List<String>? = null,
) {
    fun toMission(): Mission {
        return Mission(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            description = this.description.orEmpty(),
            imageUrl = this.image.orEmpty(),
        )
    }
}
