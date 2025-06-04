package com.adammcneilly.spacenerd.core.ui.utils

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.SharedTransitionScope.OverlayClip
import androidx.compose.animation.SharedTransitionScope.SharedContentState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.adammcneilly.spacenerd.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.scaffold.LocalSharedTransitionScope

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun Modifier.sharedBounds(
    key: String,
    resizeMode: SharedTransitionScope.ResizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(),
    clipShapeInOverlayDuringTransition: Shape? = null,
): Modifier {
    val sharedTransitionScope = LocalSharedTransitionScope.current
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current

    if (sharedTransitionScope == null || animatedVisibilityScope == null) {
        return this
    }

    val overlayClip = if (clipShapeInOverlayDuringTransition != null) {
        sharedTransitionScope.OverlayClip(clipShapeInOverlayDuringTransition)
    } else {
        ParentClip
    }

    return with(sharedTransitionScope) {
        sharedBounds(
            sharedContentState = rememberSharedContentState(
                key = key,
            ),
            animatedVisibilityScope = animatedVisibilityScope,
            resizeMode = resizeMode,
            clipInOverlayDuringTransition = overlayClip,
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
private val ParentClip: OverlayClip =
    object : OverlayClip {
        override fun getClipPath(
            sharedContentState: SharedContentState,
            bounds: Rect,
            layoutDirection: LayoutDirection,
            density: Density,
        ): Path? {
            return sharedContentState.parentSharedContentState?.clipPathInOverlay
        }
    }
