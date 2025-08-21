package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDCurrentlyDockedDTO(
    @SerialName("departure")
    val departure: String? = null,
    @SerialName("docking")
    val docking: String? = null,
    @SerialName("flight_vehicle_chaser")
    val flightVehicleChaser: TSDFlightVehicleChaserDTO? = null,
    @SerialName("id")
    val id: Int? = null,
//    @SerialName("payload_flight_chaser")
//    val payloadFlightChaser: Any? = null,
//    @SerialName("space_station_chaser")
//    val spaceStationChaser: Any? = null,
    @SerialName("url")
    val url: String? = null,
)
