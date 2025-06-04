package com.adammcneilly.spacenerd.feature.news

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

@Suppress("ForbiddenComment")
// TODO: Move to shared module
operator fun PaddingValues.plus(
    that: PaddingValues,
): PaddingValues {
    return object : PaddingValues {
        override fun calculateBottomPadding(): Dp = this@plus.calculateBottomPadding() + that.calculateBottomPadding()

        override fun calculateLeftPadding(
            layoutDirection: LayoutDirection,
        ): Dp = this@plus.calculateLeftPadding(layoutDirection) + that.calculateLeftPadding(layoutDirection)

        override fun calculateRightPadding(
            layoutDirection: LayoutDirection,
        ): Dp = this@plus.calculateRightPadding(layoutDirection) + that.calculateRightPadding(layoutDirection)

        override fun calculateTopPadding(): Dp = this@plus.calculateTopPadding() + that.calculateTopPadding()
    }
}
