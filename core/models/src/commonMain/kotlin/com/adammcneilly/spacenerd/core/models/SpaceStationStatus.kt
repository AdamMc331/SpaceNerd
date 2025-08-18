package com.adammcneilly.spacenerd.core.models

/**
 * Represents the various states that a [SpaceStation] can be in.
 */
enum class SpaceStationStatus {
    /**
     * The space station is currently active and operational.
     */
    Active,

    /**
     * The space station has been de-orbited.
     */
    DeOrbited,

    /**
     * The space station has been decommissioned.
     */
    Decommissioned,

    /**
     * The status of the space station is unknown.
     */
    Unknown,
}
