package com.adammcneilly.spacenerd.core.models

/**
 * Represents a launchpad where a rocket can be launched from.
 *
 * @property[id] A unique identifier for this launchpad.
 * @property[name] The name of this launchpad.
 * @property[location] The location of this launchpad.
 */
data class LaunchPad(
    val id: String,
    val name: String,
    val location: Location?,
)
