package com.adammcneilly.spacenerd.data.agency.impl.tsd

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.Country
import com.adammcneilly.spacenerd.data.agency.impl.remote.tsd.TSDAgencyService
import com.adammcneilly.spacenerd.data.remote.tsd.test.FakeTSDKtorClient
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TSDAgencyServiceTest {
    private val service = TSDAgencyService(
        client = FakeTSDKtorClient,
    )

    @Test
    fun parseSpaceStationsSuccess() =
        runTest {
            val agency = service
                .getAgency("123")
                .getOrThrow()

            val expectedAgency = Agency(
                id = "44",
                name = "National Aeronautics and Space Administration",
                abbreviation = "NASA",
                description = "nasaDescription",
                logoUrl = "nasaImageUrl",
                countries = listOf(
                    Country(
                        id = "2",
                        name = "United States of America",
                        alpha3Code = "USA",
                    ),
                ),
            )

            assertThat(agency).isEqualTo(expectedAgency)
        }
}
