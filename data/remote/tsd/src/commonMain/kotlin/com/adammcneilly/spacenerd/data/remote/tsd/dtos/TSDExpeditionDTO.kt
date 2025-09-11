package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import com.adammcneilly.spacenerd.core.models.Expedition
import kotlinx.datetime.toInstant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class TSDExpeditionDTO(
    @SerialName("crew")
    val crew: List<TSDCrewMemberDTO>? = null,
    @SerialName("end")
    val end: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("mission_patches")
    val missionPatches: List<TSDMissionPatchesDTO>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("response_mode")
    val responseMode: String? = null,
    @SerialName("spacestation")
    val spacestation: TSDSpaceStationSummaryDTO? = null,
//    @SerialName("spacewalks")
//    val spacewalks: List<Any?>? = listOf(),
    @SerialName("start")
    val start: String? = null,
    @SerialName("url")
    val url: String? = null,
) {
    @OptIn(ExperimentalTime::class)
    fun toExpedition(): Expedition {
        return Expedition(
            id = id.toString(),
            start = Instant.parse(this.start.orEmpty()),
            end = this.end?.let {
                Instant.parse(it)
            },
            name = this.name.orEmpty(),
            spaceStation = this.spacestation?.toSpaceStation(),
            crew = this.crew?.map(TSDCrewMemberDTO::toCrewMember).orEmpty(),
        )
    }
}
