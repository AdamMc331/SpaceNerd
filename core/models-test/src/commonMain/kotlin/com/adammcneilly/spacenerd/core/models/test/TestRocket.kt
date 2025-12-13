package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.Rocket
import kotlinx.datetime.LocalDate

val testRocket = Rocket(
    id = "123",
    name = "Falcon 9",
    imageUrl = "Falcon 9 Image URL",
    manufacturer = testAgency,
    description = "Falcon 9 description",
    maidenFlight = LocalDate.parse("2025-10-08"),
    totalLaunches = 123,
)
