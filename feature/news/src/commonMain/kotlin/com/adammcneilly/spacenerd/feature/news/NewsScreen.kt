package com.adammcneilly.spacenerd.feature.news

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import com.adammcneilly.spacenerd.core.ui.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.ui.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.ui.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.ui.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel,
) {
    val state = viewModel.state.collectAsState()

    val selectedArticle = state.value.selectedArticle
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(selectedArticle) {
        if (selectedArticle != null) {
            uriHandler.openUri(selectedArticle.url)
            viewModel.onEvent(NewsEvent.NavigatedToArticle(selectedArticle))
        }
    }

    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        navigationBar = {
            PersistentNavigationBar()
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        content = { scaffoldPadding ->
            NewsContent(
                state = state.value,
                contentPadding = scaffoldPadding,
                onEvent = viewModel::onEvent,
            )
        },
    )
}
