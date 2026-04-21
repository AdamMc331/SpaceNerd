package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Mission

/**
 * A user-friendly representation of a mission.
 *
 * @property[id] A unique identifier for this mission.
 * @property[name] The name of this mission.
 * @property[description] A brief summary of this mission.
 * @property[image] The image for this mission.
 * @property[isPlaceholder] If true, this display model is just a placeholder and the UI
 * should reflect that.
 */
data class MissionDisplayModel(
    val id: String,
    val name: String,
    val description: String,
    val image: ImageModel,
    val type: String,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        mission: Mission,
    ) : this (
        id = mission.id,
        name = mission.name,
        description = mission.description,
        type = mission.type,
        image = ImageModel.Remote(mission.imageUrl),
    )

    companion object {
        fun placeholder(): MissionDisplayModel {
            return MissionDisplayModel(
                id = "",
                name = "Mission Placeholder",
                description = "Some longer description of the mission\nmultiline for sure",
                type = "Communications",
                image = ImageModel.Placeholder,
                isPlaceholder = true,
            )
        }
    }
}
