package com.adammcneilly.spacenerd.test.paparazzi.feature.stationlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.feature.stationlist.SpaceStationSummaryCard
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import org.junit.Test

class SpaceStationSummaryCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        val station = SpaceStationDisplayModel.placeholder()

        snapshot {
            SpaceStationSummaryCard(
                station = station,
            )
        }
    }

    @Test
    fun renderDefault() {
        snapshot {
            SpaceStationSummaryCard(
                station = SpaceStationDisplayModel(testSpaceStation),
            )
        }
    }
}
