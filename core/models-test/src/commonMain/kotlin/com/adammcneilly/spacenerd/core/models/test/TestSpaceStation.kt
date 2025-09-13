package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import kotlinx.datetime.LocalDate

val testSpaceStation = SpaceStation(
    id = "123",
    name = "International Space Station",
    status = SpaceStationStatus.Active,
    imageUrl = "Station Image",
    founded = LocalDate(1998, 11, 20),
    agencies = listOf(
        testAgency,
        testAgency,
        testAgency,
    ),
)
