package com.adammcneilly.spacenerd.core.models

/**
 * Represents a space station that is orbiting the Earth.
 *
 * @property[id] A unique identifier for this space station.
 * @property[name] The name of this space station.
 * @property[status] The current status of this space station. See [SpaceStationStatus].
 * @property[imageUrl] A URL to an image of this space station.
 */
data class SpaceStation(
    val id: String,
    val name: String,
    val status: SpaceStationStatus,
    val imageUrl: String,
)
