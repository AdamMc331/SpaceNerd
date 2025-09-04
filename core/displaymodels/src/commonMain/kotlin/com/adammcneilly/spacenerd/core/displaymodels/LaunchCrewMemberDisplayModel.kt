package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.LaunchCrewMember

/**
 * User friendly representation of a [LaunchCrewMember].
 */
data class LaunchCrewMemberDisplayModel(
    val id: String,
    val role: AstronautRoleDisplayModel,
    val astronaut: AstronautDisplayModel,
    val placeholder: Boolean = false,
) {
    constructor(
        launchCrewMember: LaunchCrewMember,
    ) : this(
        id = launchCrewMember.id,
        role = AstronautRoleDisplayModel(launchCrewMember.role),
        astronaut = AstronautDisplayModel(launchCrewMember.astronaut),
    )

    companion object {
        fun placeholder(): LaunchCrewMemberDisplayModel {
            return LaunchCrewMemberDisplayModel(
                id = "",
                role = AstronautRoleDisplayModel(
                    id = "",
                    name = "Placeholder",
                    priority = -1,
                ),
                astronaut = AstronautDisplayModel.placeholder(),
            )
        }
    }
}
