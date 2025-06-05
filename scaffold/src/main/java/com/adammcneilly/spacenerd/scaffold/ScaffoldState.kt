package com.adammcneilly.spacenerd.scaffold

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.window.core.layout.WindowWidthSizeClass

@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> {
    null
}

/**
 * Do not create an instance of this scaffold state directly. Please use
 * [rememberScaffoldState].
 */
@OptIn(ExperimentalSharedTransitionApi::class)
class ScaffoldState internal constructor(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    private val isMediumScreenWidthOrWider: State<Boolean>,
) : AnimatedVisibilityScope by animatedVisibilityScope,
    SharedTransitionScope by sharedTransitionScope {
    val canShowBottomNavigation get() = !isMediumScreenWidthOrWider.value

    val canShowNavRail get() = isMediumScreenWidthOrWider.value
}

/**
 * Remembers an instance of [ScaffoldState] with the supplied animation scopes.
 *
 * This should be used instead of the constructor for [ScaffoldState].
 */
@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun rememberScaffoldState(
    animatedVisibilityScope: AnimatedVisibilityScope = requireNotNull(LocalNavAnimatedContentScope.current) {
        "AnimatedVisibilityScope must be provided via LocalNavAnimatedContentScope"
    },
    sharedTransitionScope: SharedTransitionScope = requireNotNull(LocalSharedTransitionScope.current) {
        "SharedTransitionScope must be provided via LocalSharedTransitionScope"
    },
): ScaffoldState {
    val isMediumScreenWidthOrWider = isMediumScreenWidthOrWider()

    return remember {
        ScaffoldState(
            animatedVisibilityScope = animatedVisibilityScope,
            sharedTransitionScope = sharedTransitionScope,
            isMediumScreenWidthOrWider = isMediumScreenWidthOrWider,
        )
    }
}

/**
 * Access the current [WindowWidthSizeClass] to determine if it's at
 * a medium or wider width class. This is used to determine whether
 * we should show a bottom navigation or a navigation rail.
 */
@Composable
private fun isMediumScreenWidthOrWider(): State<Boolean> {
    val widthSizeClass = currentWindowAdaptiveInfo()
        .windowSizeClass
        .windowWidthSizeClass

    val mediumOrHigherClasses = listOf(
        WindowWidthSizeClass.MEDIUM,
        WindowWidthSizeClass.EXPANDED,
    )

    val isMediumScreenWidthOrWider: Boolean = (widthSizeClass in mediumOrHigherClasses)

    return rememberUpdatedState(isMediumScreenWidthOrWider)
}
