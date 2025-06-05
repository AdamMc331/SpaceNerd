package com.adammcneilly.spacenerd.data.launch.impl.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.LaunchPad

@Entity(tableName = "launchpads")
data class RoomLaunchPadDTO(
    @PrimaryKey val id: String,
    val name: String,
    val location: RoomLocationDTO?,
) {
    constructor(
        launchPad: LaunchPad,
    ) : this(
        id = launchPad.id,
        name = launchPad.name,
        location = launchPad.location?.let(::RoomLocationDTO),
    )

    fun toLaunchPad(): LaunchPad {
        return LaunchPad(
            id = id,
            name = name,
            location = location?.toLocation(),
        )
    }
}
