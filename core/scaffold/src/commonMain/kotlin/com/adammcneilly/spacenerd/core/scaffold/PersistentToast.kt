package com.adammcneilly.spacenerd.core.scaffold

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun ScaffoldState.PersistentToast(
    message: String?,
    modifier: Modifier = Modifier,
    enterTransition: EnterTransition = slideInVertically(initialOffsetY = { it }),
    exitTransition: ExitTransition = slideOutVertically(targetOffsetY = { it }),
) {
    AnimatedVisibility(
        modifier = modifier
            .sharedElement(
                sharedContentState = rememberSharedContentState(
                    ToastSharedElementKey,
                ),
                animatedVisibilityScope = this,
            ),
        visible = message != null,
        enter = enterTransition,
        exit = exitTransition,
        content = {
            Surface(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                ),
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = message.orEmpty(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                )
            }
        },
    )
}

private data object ToastSharedElementKey
