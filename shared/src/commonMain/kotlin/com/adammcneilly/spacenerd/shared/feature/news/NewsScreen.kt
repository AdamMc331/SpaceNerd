package com.adammcneilly.spacenerd.shared.feature.news

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState
import com.adammcneilly.spacenerd.shared.feature.news.ui.NewsContent
import com.adammcneilly.spacenerd.shared.feature.news.ui.NewsUiEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()

    val selectedArticle = state.value.selectedArticle
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(selectedArticle) {
        if (selectedArticle != null) {
            uriHandler.openUri(selectedArticle.url)
            viewModel.onEvent(NewsUiEvent.NavigatedToArticle(selectedArticle))
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
