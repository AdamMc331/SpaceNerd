package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.SpaceStation

val testSpaceStation = SpaceStation(
    id = "123",
    name = "International Space Station",
    status = SpaceStation.Status.Active,
    imageUrl = "Station Image",
)
