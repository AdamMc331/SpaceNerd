package com.adammcneilly.spacenerd.core.models

/**
 * Represents a location where a launch pad may reside.
 *
 * @property[id] A unique identifier for this location.
 * @property[name] The name of this location.
 */
data class Location(
    val id: String,
    val name: String,
)
