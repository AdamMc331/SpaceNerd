package com.adammcneilly.spacenerd.shared.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Mission

data class MissionDisplayModel(
    val id: String,
    val name: String,
    val description: String,
    val image: ImageDisplayModel,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        mission: Mission,
    ) : this (
        id = mission.id,
        name = mission.name,
        description = mission.description,
        image = ImageDisplayModel.Remote(mission.imageUrl),
    )

    companion object {
        fun placeholder(): MissionDisplayModel {
            return MissionDisplayModel(
                id = "",
                name = "Mission Placeholder",
                description = "Some longer description of the mission\nmultiline for sure",
                image = ImageDisplayModel.Placeholder,
                isPlaceholder = true,
            )
        }
    }
}
