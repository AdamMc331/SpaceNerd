package com.adammcneilly.spacenerd.data.launch.impl.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.LaunchServiceProvider

@Entity(tableName = "launchserviceproviders")
data class RoomLaunchServiceProviderDTO(
    @PrimaryKey val id: String,
    val name: String,
    val abbreviation: String,
) {
    constructor(
        launchServiceProvider: LaunchServiceProvider,
    ) : this(
        id = launchServiceProvider.id,
        name = launchServiceProvider.name,
        abbreviation = launchServiceProvider.abbreviation,
    )

    fun toLaunchServiceProvider(): LaunchServiceProvider {
        return LaunchServiceProvider(
            id = id,
            name = name,
            abbreviation = abbreviation,
        )
    }
}
