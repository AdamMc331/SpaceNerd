package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDNationalityDTO(
    @SerialName("alpha_2_code")
    val alpha2Code: String? = null,
    @SerialName("alpha_3_code")
    val alpha3Code: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("nationality_name")
    val nationalityName: String? = null,
    @SerialName("nationality_name_composed")
    val nationalityNameComposed: String? = null,
)
