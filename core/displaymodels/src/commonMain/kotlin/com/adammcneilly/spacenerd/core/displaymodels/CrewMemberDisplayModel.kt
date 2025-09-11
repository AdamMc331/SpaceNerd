package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.CrewMember

/**
 * User friendly representation of a [CrewMember].
 */
data class CrewMemberDisplayModel(
    val id: String,
    val role: AstronautRoleDisplayModel,
    val astronaut: AstronautDisplayModel,
    val placeholder: Boolean = false,
) {
    constructor(
        crewMember: CrewMember,
    ) : this(
        id = crewMember.id,
        role = AstronautRoleDisplayModel(crewMember.role),
        astronaut = AstronautDisplayModel(crewMember.astronaut),
    )

    companion object {
        fun placeholder(): CrewMemberDisplayModel {
            return CrewMemberDisplayModel(
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
