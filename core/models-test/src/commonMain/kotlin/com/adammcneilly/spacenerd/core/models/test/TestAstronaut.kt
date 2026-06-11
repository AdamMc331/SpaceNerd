package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.core.models.AstronautStatus

val testAstronaut = Astronaut(
    id = "585",
    name = "Sergey Ryzhikov",
    imageUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sergey_ryzhikov_image_20200603213525.jpg",
    bio = "Sergey Ryzhikov bio.",
    agency = testAgency,
    nationalities = listOf(testCountry),
    inSpace = false,
    status = AstronautStatus.Active,
)
