package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDFlightVehicleChaserDTO(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("launch")
    val launch: TSDLaunchDTO? = null,
    @SerialName("spacecraft")
    val spacecraft: TSDSpacecraftDTO? = null,
    @SerialName("url")
    val url: String? = null,
)
