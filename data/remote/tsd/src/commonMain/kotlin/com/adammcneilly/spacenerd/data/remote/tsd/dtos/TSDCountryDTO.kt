package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.Country
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDCountryDTO(
    @SerialName(value = "alpha_2_code")
    val alpha2Code: String? = null,
    @SerialName(value = "alpha_3_code")
    val alpha3Code: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "nationality_name")
    val nationalityName: String? = null,
    @SerialName(value = "nationality_name_composed")
    val nationalityNameComposed: String? = null,
) {
    fun toCountry(): Country {
        return Country(
            id = this.id?.toString().orEmpty(),
            name = this.name.orEmpty(),
            alpha3Code = this.alpha3Code.orEmpty(),
        )
    }
}
