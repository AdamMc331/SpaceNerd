package com.adammcneilly.spacenerd.core.models

import kotlinx.datetime.LocalDate
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Represents a space station that is orbiting the Earth.
 *
 * @property[id] A unique identifier for this space station.
 * @property[name] The name of this space station.
 * @property[status] The current status of this space station. See [SpaceStationStatus].
 * @property[imageUrl] A URL to an image of this space station.
 * @property[agencies] A list of [Agency] entitities that collaborate on managing this station.
 * @property[founded] The date this space station was founded.
 */
data class SpaceStation(
    val id: String,
    val name: String,
    val status: SpaceStationStatus,
    val imageUrl: String,
    val agencies: List<Agency>,
    val founded: LocalDate,
)
