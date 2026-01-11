package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.LaunchPad

data class LaunchPadDisplayModel(
    val id: String,
    val name: String,
    val location: String,
    val placeholder: Boolean = false,
) {
    constructor(launchPad: LaunchPad) : this(
        id = launchPad.id,
        name = launchPad.name,
        location = launchPad.location?.name.orEmpty(),
    )

    companion object {
        fun placeholder(): LaunchPadDisplayModel {
            return LaunchPadDisplayModel(
                id = "123",
                name = "Placeholder Name",
                location = "Placeholder Location",
                placeholder = true,
            )
        }
    }
}
