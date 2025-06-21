package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import com.adammcneilly.spacenerd.shared.core.models.Agency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLaunchServiceProviderDTO(
    @SerialName(value = "abbrev")
    val abbrev: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "type")
    val type: TSDTypeDTO? = null,
    @SerialName(value = "url")
    val url: String? = null,
) {
    fun toAgency(): Agency {
        return Agency(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            abbreviation = this.abbrev.orEmpty(),
        )
    }
}
