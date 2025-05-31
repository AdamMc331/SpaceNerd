package com.adammcneilly.spacenerd.data.thespacedevs.dto

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.datetime.Instant

@JsonClass(generateAdapter = true)
data class TSDLaunchDTO(
    @Json(name = "agency_launch_attempt_count")
    val agencyLaunchAttemptCount: Int? = null,
    @Json(name = "agency_launch_attempt_count_year")
    val agencyLaunchAttemptCountYear: Int? = null,
    @Json(name = "failreason")
    val failreason: String? = null,
    @Json(name = "hashtag")
    val hashtag: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "image")
    val image: TSDImageDTO? = null,
    @Json(name = "infographic")
    val infographic: String? = null,
    @Json(name = "last_updated")
    val lastUpdated: String? = null,
    @Json(name = "launch_designator")
    val launchDesignator: String? = null,
    @Json(name = "launch_service_provider")
    val launchServiceProvider: TSDLaunchServiceProviderDTO? = null,
    @Json(name = "location_launch_attempt_count")
    val locationLaunchAttemptCount: Int? = null,
    @Json(name = "location_launch_attempt_count_year")
    val locationLaunchAttemptCountYear: Int? = null,
    @Json(name = "mission")
    val mission: TSDMissionDTO? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "net")
    val net: String? = null,
    @Json(name = "net_precision")
    val netPrecision: TSDNetPrecisionDTO? = null,
    @Json(name = "orbital_launch_attempt_count")
    val orbitalLaunchAttemptCount: Int? = null,
    @Json(name = "orbital_launch_attempt_count_year")
    val orbitalLaunchAttemptCountYear: Int? = null,
    @Json(name = "pad")
    val pad: TSDPadDTO? = null,
    @Json(name = "pad_launch_attempt_count")
    val padLaunchAttemptCount: Int? = null,
    @Json(name = "pad_launch_attempt_count_year")
    val padLaunchAttemptCountYear: Int? = null,
    @Json(name = "probability")
    val probability: String? = null,
    @Json(name = "program")
    val program: List<TSDProgramDTO>? = null,
    @Json(name = "response_mode")
    val responseMode: String? = null,
    @Json(name = "rocket")
    val rocket: TSDRocketDTO? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "status")
    val status: TSDStatusDTO? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "weather_concerns")
    val weatherConcerns: String? = null,
    @Json(name = "webcast_live")
    val webcastLive: Boolean? = null,
    @Json(name = "window_end")
    val windowEnd: String? = null,
    @Json(name = "window_start")
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
