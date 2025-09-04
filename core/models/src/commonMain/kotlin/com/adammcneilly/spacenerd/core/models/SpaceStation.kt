package com.adammcneilly.spacenerd.core.models

import kotlinx.datetime.LocalDate

/**
 * Represents a space station that is orbiting the Earth.
 *
 * @property[id] A unique identifier for this space station.
 * @property[name] The name of this space station.
 * @property[status] The current status of this space station. See [SpaceStationStatus].
 * @property[imageUrl] A URL to an image of this space station.
 * @property[agencies] A list of [Agency] entities that collaborate on managing this station.
 * @property[founded] The date this space station was founded.
 * @param[onboardCrew] A list of [Astronaut] entities for people currently onboard this space station.
 */
data class SpaceStation(
    val id: String,
    val name: String,
    val status: SpaceStationStatus,
    val imageUrl: String,
    val agencies: List<Agency>,
    val founded: LocalDate,
    val onboardCrew: List<Astronaut>,
)
