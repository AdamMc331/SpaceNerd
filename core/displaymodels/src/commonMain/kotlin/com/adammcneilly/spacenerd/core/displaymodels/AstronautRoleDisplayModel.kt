package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.AstronautRole

/**
 * User friendly representation of an [AstronautRole].
 */
data class AstronautRoleDisplayModel(
    val id: String,
    val name: String,
    val priority: Int,
) {
    constructor(
        role: AstronautRole,
    ) : this(
        id = role.id,
        name = role.name,
        priority = role.priority,
    )
}
