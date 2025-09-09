package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.LaunchPad
import com.adammcneilly.spacenerd.core.models.Location

@Entity(tableName = "launch_pads")
data class RoomLaunchPadDTO(
    @PrimaryKey val launchPadId: String,
    val name: String,
    @Embedded(prefix = "launchlocation_") val location: Location?,
) {
    constructor(
        launchPad: LaunchPad,
    ) : this(
        launchPadId = launchPad.id,
        name = launchPad.name,
        location = launchPad.location,
    )

    fun toLaunchPad(): LaunchPad {
        return LaunchPad(
            id = launchPadId,
            name = name,
            location = location,
        )
    }
}
