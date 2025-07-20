package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
val testLaunch = Launch(
    id = "test_launch_id",
    name = "Test Launch Name",
    imageUrl = "ImageUrl",
    launchTime = Instant.parse("2023-01-01T00:00:00Z"),
    status = LaunchStatus.TBD,
    agency = testAgency,
    pad = testLaunchPad,
    mission = testMission,
)
