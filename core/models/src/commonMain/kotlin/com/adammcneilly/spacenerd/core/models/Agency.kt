package com.adammcneilly.spacenerd.core.models

/**
 * Represents a space agency that is responsible for a launch.
 *
 * @property[id] A unique identifier for this agency.
 * @property[name] The full name of this agency.
 * @property[abbreviation] The abbreviated name of this agency.
 * @property[description] A summary of this agency.
 * @property[logoUrl] A URL to the logo for this agency.
 * @property[countries] A collection of [Country]s that manage this agency.
 */
data class Agency(
    val id: String,
    val name: String,
    val abbreviation: String,
    val description: String,
    val logoUrl: String,
    val countries: List<Country>,
)
