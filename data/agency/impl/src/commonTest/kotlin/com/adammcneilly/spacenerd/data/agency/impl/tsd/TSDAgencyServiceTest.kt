package com.adammcneilly.spacenerd.data.agency.impl.tsd

import com.adammcneilly.spacenerd.core.models.Agency
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
                description = "The National Aeronautics and Space Administration is an independent agency of the executive branch of the United States federal government responsible for the civilian space program, as well as aeronautics and aerospace research. NASA have many launch facilities but most are inactive. The most commonly used pad will be LC-39B at Kennedy Space Center in Florida.",
                logoUrl = "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/national2520aeronautics2520and2520space2520administration_logo_20190207032448.png",
            )

            assertThat(agency).isEqualTo(expectedAgency)
        }
}
