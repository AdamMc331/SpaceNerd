package com.adammcneilly.spacenerd.shared.data.launch.local.room.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.LaunchPad
import com.adammcneilly.spacenerd.core.models.Location

@Entity(tableName = "launchpads")
data class RoomLaunchPadDTO(
    @PrimaryKey val id: String,
    val name: String,
    @Embedded(prefix = "launchlocation_") val location: Location?,
) {
    constructor(
        launchPad: LaunchPad,
    ) : this(
        id = launchPad.id,
        name = launchPad.name,
        location = launchPad.location,
    )

    fun toLaunchPad(): LaunchPad {
        return LaunchPad(
            id = id,
            name = name,
            location = location,
        )
    }
}
