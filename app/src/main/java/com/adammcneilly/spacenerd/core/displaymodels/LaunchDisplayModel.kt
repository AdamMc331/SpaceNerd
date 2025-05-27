package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Launch

data class LaunchDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
) {
    constructor(launch: Launch) : this(
        id = launch.id,
        name = launch.name,
        image = ImageDisplayModel.Remote(launch.imageUrl),
    )
}
