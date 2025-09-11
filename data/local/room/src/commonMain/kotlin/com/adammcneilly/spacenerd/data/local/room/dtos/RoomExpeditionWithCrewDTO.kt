package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Relation
import com.adammcneilly.spacenerd.core.models.Expedition
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class RoomExpeditionWithCrewDTO(
    @Embedded val expedition: RoomExpeditionDTO,
    @Relation(
        parentColumn = "spaceStationId",
        entityColumn = "spaceStationId",
    )
    val spaceStation: RoomSpaceStationDTO?,
    @Relation(
        parentColumn = "expeditionId",
        entityColumn = "expeditionId",
        entity = RoomCrewMemberDTO::class,
    )
    val crew: List<RoomCrewMemberDetailDTO>,
) {
    fun toExpedition(): Expedition {
        return Expedition(
            id = this.expedition.expeditionId,
            start = Instant.parse(this.expedition.expeditionStart),
            end = this.expedition.expeditionEnd?.let { end ->
                Instant.parse(end)
            },
            name = this.expedition.name,
            spaceStation = this.spaceStation?.toSpaceStation(),
            crew = this.crew.map(RoomCrewMemberDetailDTO::toCrewMember),
        )
    }
}
