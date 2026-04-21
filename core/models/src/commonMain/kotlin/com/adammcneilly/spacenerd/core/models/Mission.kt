package com.adammcneilly.spacenerd.core.models

/**
 * Represents a mission that a rocket launch is responsible for.
 *
 * @property[id] A unique identifier for this mission.
 * @property[name] The name of this mission.
 * @property[description] A summary of this mission.
 * @property[imageUrl] A URL to an image representing this mission.
 * @property[type] An explanation of the purpose of the mission, for example "Communications".
 */
data class Mission(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val type: String,
)
