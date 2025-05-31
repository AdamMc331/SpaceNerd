package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Launch

data class LaunchDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
    val status: LaunchStatusDisplayModel,
    val subtitle: String,
) {
    constructor(launch: Launch) : this(
        id = launch.id,
        name = launch.name,
        image = ImageDisplayModel.Remote(launch.imageUrl),
        status = LaunchStatusDisplayModel(launch.status),
        subtitle = launch.buildSubtitle(),
    )
}

private fun Launch.buildSubtitle(): String {
    val providerName = this.provider?.name
    val locationName = this.pad?.location?.name

    return listOfNotNull(providerName, locationName).joinToString(" • ")
}
