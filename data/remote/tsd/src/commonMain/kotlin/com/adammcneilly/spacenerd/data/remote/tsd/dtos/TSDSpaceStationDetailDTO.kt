package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class TSDSpaceStationDetailDTO(
//    @SerialName("active_docking_events")
//    val activeDockingEvents: List<Any?>? = listOf(),
    @SerialName("active_expeditions")
    val activeExpeditions: List<TSDActiveExpeditionDTO>? = null,
    @SerialName("deorbited")
    val deorbited: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("docked_vehicles")
    val dockedVehicles: Int? = null,
    @SerialName("docking_location")
    val dockingLocation: List<TSDDockingLocationDTO>? = null,
    @SerialName("founded")
    val founded: String? = null,
    @SerialName("height")
    val height: Double? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: TSDImageDTO? = null,
    @SerialName("mass")
    val mass: Double? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("onboard_crew")
    val onboardCrew: Int? = null,
    @SerialName("orbit")
    val orbit: String? = null,
    @SerialName("owners")
    val owners: List<TSDAgencyDTO>? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("status")
    val status: TSDStatusDTO? = null,
    @SerialName("type")
    val type: TSDTypeDTO? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("volume")
    val volume: Int? = null,
    @SerialName("width")
    val width: Double? = null,
) {
    @OptIn(ExperimentalTime::class)
    fun toSpaceStation(): SpaceStation {
        return SpaceStation(
            id = this.id.toString(),
            name = this.name.orEmpty(),
            status = this.status?.toSpaceStationStatus() ?: SpaceStationStatus.Unknown,
            imageUrl = this.image?.imageUrl.orEmpty(),
            agencies = this.owners?.map(TSDAgencyDTO::toAgency).orEmpty(),
            founded = LocalDate.parse(this.founded.orEmpty()),
        )
    }
}
