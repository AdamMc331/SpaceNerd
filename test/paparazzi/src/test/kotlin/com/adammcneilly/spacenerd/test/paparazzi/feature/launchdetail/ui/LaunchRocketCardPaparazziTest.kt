package com.adammcneilly.spacenerd.test.paparazzi.feature.launchdetail.ui

import com.adammcneilly.spacenerd.core.displaymodels.RocketDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testRocket
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchRocketCard
import com.adammcneilly.spacenerd.test.paparazzi.BasePaparazziTest
import kotlin.test.Test

class LaunchRocketCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderPlaceholder() {
        snapshot {
            LaunchRocketCard(
                rocket = RocketDisplayModel.placeholder(),
            )
        }
    }

    @Test
    fun renderDefault() {
        snapshot {
            LaunchRocketCard(
                rocket = RocketDisplayModel(testRocket),
            )
        }
    }
}
