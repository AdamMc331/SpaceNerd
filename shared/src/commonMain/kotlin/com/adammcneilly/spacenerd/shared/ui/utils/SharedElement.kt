package com.adammcneilly.spacenerd.shared.ui.utils

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.shared.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.spacenerd.shared.scaffold.LocalSharedTransitionScope

/**
 * Custom wrapper around the Compose foundation sharedElement modifier, that will only apply
 * if we have the relevant local scopes defined. Otherwise we'll return early with the current modifier.
 */
@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun Modifier.sharedElement(
    key: String,
): Modifier {
    val sharedTransitionScope = LocalSharedTransitionScope.current
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
    val localSceneType = LocalSceneType.current

    if (
        sharedTransitionScope == null ||
        animatedVisibilityScope == null ||
        (localSceneType == SceneType.TwoPane)
    ) {
        return this
    }

    return with(sharedTransitionScope) {
        this@sharedElement.sharedElement(
            sharedContentState = rememberSharedContentState(
                key = key,
            ),
            animatedVisibilityScope = animatedVisibilityScope,
        )
    }
}
