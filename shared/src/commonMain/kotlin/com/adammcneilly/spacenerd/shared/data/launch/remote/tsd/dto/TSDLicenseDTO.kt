package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLicenseDTO(
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "link")
    val link: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "priority")
    val priority: Int? = null,
)
