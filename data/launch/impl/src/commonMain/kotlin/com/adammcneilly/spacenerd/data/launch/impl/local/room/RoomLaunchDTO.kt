package com.adammcneilly.spacenerd.data.launch.impl.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import kotlinx.datetime.Instant

@Entity(tableName = "launches")
data class RoomLaunchDTO(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val launchTimeUtc: String,
    val status: LaunchStatus,
    val provider: RoomLaunchServiceProviderDTO?,
    val pad: RoomLaunchPadDTO?,
) {
    constructor(
        launch: Launch,
    ) : this(
        id = launch.id,
        name = launch.name,
        imageUrl = launch.imageUrl,
        launchTimeUtc = launch.launchTimeUtc.toString(),
        status = launch.status,
        provider = launch.provider?.let(::RoomLaunchServiceProviderDTO),
        pad = launch.pad?.let(::RoomLaunchPadDTO),
    )

    fun toLaunch(): Launch {
        return Launch(
            id = id,
            name = name,
            imageUrl = imageUrl,
            launchTimeUtc = Instant.parse(launchTimeUtc),
            status = status,
            provider = provider?.toLaunchServiceProvider(),
            pad = pad?.toLaunchPad(),
        )
    }
}
