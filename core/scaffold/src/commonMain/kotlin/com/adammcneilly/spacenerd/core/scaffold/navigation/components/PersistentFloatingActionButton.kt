package com.adammcneilly.spacenerd.core.scaffold.navigation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.scaffold.ScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun ScaffoldState.PersistentFloatingActionButton(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enterTransition: EnterTransition = slideInVertically(initialOffsetY = { it }),
    exitTransition: ExitTransition = slideOutVertically(targetOffsetY = { it }),
) {
    AnimatedVisibility(
        modifier = modifier
            .sharedElement(
                sharedContentState = rememberSharedContentState(
                    FloatingActionButtonSharedElementKey,
                ),
                animatedVisibilityScope = this,
            ),
        visible = canShowBottomNavigation,
        enter = enterTransition,
        exit = exitTransition,
        content = {
            ExtendedFloatingActionButton(
                text = text,
                icon = icon,
                onClick = onClick,
            )
        },
    )
}

private data object FloatingActionButtonSharedElementKey
