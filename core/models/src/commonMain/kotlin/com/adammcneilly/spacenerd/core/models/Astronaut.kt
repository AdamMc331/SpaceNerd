package com.adammcneilly.spacenerd.core.models

/**
 * Represents an Astronaut.
 *
 * @property[id] A unique identifier for this person.
 * @param[name] The astronaut's full name (first and last).
 * @param[bio] A short description of this astronaut.
 * @param[imageUrl] Remote url to an image of this astronaut.
 * @param[agency] The [Agency] this Astronaut is associated with, if any.
 */
data class Astronaut(
    val id: String,
    val name: String,
    val bio: String,
    val imageUrl: String,
    val agency: Agency?,
)
