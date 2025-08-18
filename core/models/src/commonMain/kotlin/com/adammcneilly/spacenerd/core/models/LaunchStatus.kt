package com.adammcneilly.spacenerd.core.models

/**
 * Represents the various states that a [Launch] can be in.
 */
enum class LaunchStatus {
    /**
     * The launch is confirmed and scheduled to go.
     */
    Go,

    /**
     * A firm launch date has not been determined.
     */
    TBD,

    /**
     * The launch was a success.
     */
    Success,

    /**
     * The launch failed.
     */
    Failure,

    /**
     * The launch is currently on hold.
     */
    Hold,

    /**
     * The launch is currently in flight.
     */
    InFlight,

    /**
     * The launch was a partial failure.
     */
    PartialFailure,

    /**
     * A firm launch date is to be confirmed.
     */
    TBC,

    /**
     * The payload has been successfully deployed.
     */
    Deployed,

    /**
     * The status of the launch is unknown.
     */
    Unknown,
}
