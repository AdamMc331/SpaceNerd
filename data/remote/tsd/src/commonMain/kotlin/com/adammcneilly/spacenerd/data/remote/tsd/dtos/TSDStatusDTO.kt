package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDStatusDTO(
    @SerialName(value = "abbrev")
    val abbrev: String? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
) {
    @Suppress("MagicNumber")
    fun toLaunchStatus(): LaunchStatus {
        return when (this.id) {
            1 -> LaunchStatus.Go
            2 -> LaunchStatus.TBD
            3 -> LaunchStatus.Success
            4 -> LaunchStatus.Failure
            5 -> LaunchStatus.Hold
            6 -> LaunchStatus.InFlight
            7 -> LaunchStatus.PartialFailure
            8 -> LaunchStatus.TBC
            9 -> LaunchStatus.Deployed
            else -> LaunchStatus.Unknown
        }
    }

    @Suppress("MagicNumber")
    fun toSpaceStationStatus(): SpaceStationStatus {
        return when (this.id) {
            1 -> SpaceStationStatus.Active
            2 -> SpaceStationStatus.DeOrbited
            3 -> SpaceStationStatus.Decommissioned
            else -> SpaceStationStatus.Unknown
        }
    }
}
