package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Mission

data class MissionDisplayModel(
    val id: String,
    val name: String,
    val description: String,
    val image: ImageModel,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        mission: Mission,
    ) : this (
        id = mission.id,
        name = mission.name,
        description = mission.description,
        image = ImageModel.Remote(mission.imageUrl),
    )

    companion object {
        fun placeholder(): MissionDisplayModel {
            return MissionDisplayModel(
                id = "",
                name = "Mission Placeholder",
                description = "Some longer description of the mission\nmultiline for sure",
                image = ImageModel.Placeholder,
                isPlaceholder = true,
            )
        }
    }
}
