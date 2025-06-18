package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.core.models.LaunchStatus

@Entity(tableName = "launches")
data class RoomLaunchDTO(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val launchTime: String,
    val status: LaunchStatus,
    val launchServiceProviderId: String?,
    val launchPadId: String?,
) {
    constructor(
        launch: Launch,
    ) : this(
        id = launch.id,
        name = launch.name,
        imageUrl = launch.imageUrl,
        launchTime = launch.launchTime.toString(),
        status = launch.status,
        launchServiceProviderId = launch.provider?.id,
        launchPadId = launch.pad?.id,
    )
}
