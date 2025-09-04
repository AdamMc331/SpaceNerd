package com.adammcneilly.spacenerd.core.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Represents a single rocket launch.
 *
 * @property[id] A unique identifier for this launch.
 * @property[name] The name of this launch.
 * @property[imageUrl] A URL to an image of this launch.
 * @property[launchTime] The scheduled date and time of this launch.
 * @property[status] The current status of this launch.
 * @property[agency] The launch service provider for this launch.
 * @property[pad] The launchpad this launch is scheduled to take off from.
 * @property[mission] The mission that this launch is a part of.
 * @property[crew] If supplied, the list of astronauts that participated in this launch.
 */
@OptIn(ExperimentalTime::class)
data class Launch(
    val id: String,
    val name: String,
    val imageUrl: String,
    val launchTime: Instant,
    val status: LaunchStatus,
    val agency: Agency?,
    val pad: LaunchPad?,
    val mission: Mission?,
    val crew: List<LaunchCrewMember>?,
)
