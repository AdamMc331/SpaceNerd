package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TSDStatusDTO(
    @Json(name = "abbrev")
    val abbrev: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
) {
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
}
