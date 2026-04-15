package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Country

val testAgency = Agency(
    id = "test_agency_id",
    name = "Test Agency Name",
    abbreviation = "TA",
    description = "This is a test agency description.",
    logoUrl = "LogoUrl",
    countries = listOf(
        Country(
            id = "123",
            name = "Test Country",
            alpha3Code = "TCY",
        ),
    ),
)
