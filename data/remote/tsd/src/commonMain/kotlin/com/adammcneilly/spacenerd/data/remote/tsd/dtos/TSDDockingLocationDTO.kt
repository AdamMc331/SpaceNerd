package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDDockingLocationDTO(
    @SerialName("currently_docked")
    val currentlyDocked: TSDCurrentlyDockedDTO? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
)
