package com.adammcneilly.spacenerd.core.models

/**
 * Represents an Astronaut.
 *
 * @property[id] A unique identifier for this person.
 * @param[name] The astronaut's full name (first and last).
 * @param[imageUrl] Remote url to an image of this astronaut.
 */
data class Astronaut(
    val id: String,
    val name: String,
    val imageUrl: String,
)
