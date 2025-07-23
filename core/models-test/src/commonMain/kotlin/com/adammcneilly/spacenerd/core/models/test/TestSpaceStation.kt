package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

val testSpaceStation = SpaceStation(
    id = "123",
    name = "International Space Station",
    status = SpaceStationStatus.Active,
    imageUrl = "Station Image",
)
