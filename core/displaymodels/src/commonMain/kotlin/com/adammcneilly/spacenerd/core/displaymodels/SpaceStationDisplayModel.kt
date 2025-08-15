package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

data class SpaceStationDisplayModel(
    val id: String,
    val name: String,
    val image: ImageModel,
    val status: LaunchStatusDisplayModel,
    val isPlaceholder: Boolean = false,
) {
    constructor(station: SpaceStation) : this(
        id = station.id,
        name = station.name,
        image = ImageModel.Remote(station.imageUrl),
        status = LaunchStatusDisplayModel(station.status),
    )

    companion object {
        fun placeholder(): SpaceStationDisplayModel {
            return SpaceStationDisplayModel(
                id = "",
                name = "Placeholder Station",
                image = ImageModel.Placeholder,
                status = LaunchStatusDisplayModel(SpaceStationStatus.Unknown),
                isPlaceholder = true,
            )
        }
    }
}
