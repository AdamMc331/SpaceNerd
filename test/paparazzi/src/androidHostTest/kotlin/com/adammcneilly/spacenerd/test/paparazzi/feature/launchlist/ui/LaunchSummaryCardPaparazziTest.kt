package com.adammcneilly.spacenerd.test.paparazzi.feature.launchlist.ui

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testLaunch
import com.adammcneilly.spacenerd.feature.launchlist.ui.LaunchSummaryCard
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlinx.datetime.TimeZone
import org.junit.Test

class LaunchSummaryCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        val launch = LaunchDisplayModel.placeholder()

        snapshot {
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }

    @Test
    fun renderDefault() {
        snapshot {
            LaunchSummaryCard(
                launch = LaunchDisplayModel(
                    launch = testLaunch,
                    timeZone = TimeZone.UTC,
                ),
            )
        }
    }
}
