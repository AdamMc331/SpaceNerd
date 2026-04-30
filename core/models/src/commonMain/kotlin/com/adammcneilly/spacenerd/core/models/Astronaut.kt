package com.adammcneilly.spacenerd.core.models

/**
 * Represents an Astronaut.
 *
 * @property[id] A unique identifier for this person.
 * @property[name] The astronaut's full name (first and last).
 * @property[bio] A short description of this astronaut.
 * @property[imageUrl] Remote url to an image of this astronaut.
 * @property[agency] The [Agency] this Astronaut is associated with, if any.
 * @property[nationalities] The collection of [Country] that make up this Astronaut's nationalities.
 */
data class Astronaut(
    val id: String,
    val name: String,
    val bio: String,
    val imageUrl: String,
    val agency: Agency?,
    val nationalities: List<Country>,
)
