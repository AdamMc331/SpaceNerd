package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(tableName = "launches")
data class RoomLaunchDTO(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val launchTime: String,
    val status: LaunchStatus,
    val launchAgencyId: String?,
    val launchPadId: String?,
    val launchMissionId: String?,
    val rocketId: String?,
) {
    constructor(
        launch: Launch,
    ) : this(
        id = launch.id,
        name = launch.name,
        imageUrl = launch.imageUrl,
        launchTime = launch.launchTime.toString(),
        status = launch.status,
        launchAgencyId = launch.agency?.id,
        launchPadId = launch.pad?.id,
        launchMissionId = launch.mission?.id,
        rocketId = launch.rocket?.id,
    )
}
