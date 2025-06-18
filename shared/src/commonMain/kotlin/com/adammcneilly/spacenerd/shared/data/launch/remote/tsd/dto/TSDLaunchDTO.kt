package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.core.models.LaunchStatus
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDLaunchDTO(
    @SerialName(value = "agency_launch_attempt_count")
    val agencyLaunchAttemptCount: Int? = null,
    @SerialName(value = "agency_launch_attempt_count_year")
    val agencyLaunchAttemptCountYear: Int? = null,
    @SerialName(value = "failreason")
    val failreason: String? = null,
    @SerialName(value = "hashtag")
    val hashtag: String? = null,
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "image")
    val image: TSDImageDTO? = null,
    @SerialName(value = "infographic")
    val infographic: String? = null,
    @SerialName(value = "last_updated")
    val lastUpdated: String? = null,
    @SerialName(value = "launch_designator")
    val launchDesignator: String? = null,
    @SerialName(value = "launch_service_provider")
    val launchServiceProvider: TSDLaunchServiceProviderDTO? = null,
    @SerialName(value = "location_launch_attempt_count")
    val locationLaunchAttemptCount: Int? = null,
    @SerialName(value = "location_launch_attempt_count_year")
    val locationLaunchAttemptCountYear: Int? = null,
    @SerialName(value = "mission")
    val mission: TSDMissionDTO? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "net")
    val net: String? = null,
    @SerialName(value = "net_precision")
    val netPrecision: TSDNetPrecisionDTO? = null,
    @SerialName(value = "orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int? = null,
    @SerialName(value = "orbital_launch_attempt_count_year")
    val orbitalLaunchAttemptCountYear: Int? = null,
    @SerialName(value = "pad")
    val pad: TSDPadDTO? = null,
    @SerialName(value = "pad_launch_attempt_count")
    val padLaunchAttemptCount: Int? = null,
    @SerialName(value = "pad_launch_attempt_count_year")
    val padLaunchAttemptCountYear: Int? = null,
    @SerialName(value = "probability")
    val probability: String? = null,
    @SerialName(value = "program")
    val program: List<TSDProgramDTO>? = null,
    @SerialName(value = "response_mode")
    val responseMode: String? = null,
    @SerialName(value = "rocket")
    val rocket: TSDRocketDTO? = null,
    @SerialName(value = "slug")
    val slug: String? = null,
    @SerialName(value = "status")
    val status: TSDStatusDTO? = null,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "weather_concerns")
    val weatherConcerns: String? = null,
    @SerialName(value = "webcast_live")
    val webcastLive: Boolean? = null,
    @SerialName(value = "window_end")
    val windowEnd: String? = null,
    @SerialName(value = "window_start")
    val windowStart: String? = null,
) {
    fun toLaunch(): Launch {
        return Launch(
            id = this.id.orEmpty(),
            name = this.name.orEmpty(),
            imageUrl = this.image?.imageUrl.orEmpty(),
            launchTime = Instant.parse(this.net.orEmpty()),
            status = this.status?.toLaunchStatus() ?: LaunchStatus.Unknown,
            provider = this.launchServiceProvider?.toLaunchServiceProvider(),
            pad = this.pad?.toLaunchPad(),
        )
    }
}
