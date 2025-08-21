package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.scaffold.PersistentScaffold
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.spacenerd.core.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.spacenerd.core.scaffold.rememberScaffoldState

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
fun StationDetailScreen(
    stationId: String,
    modifier: Modifier = Modifier,
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        content = { scaffoldPadding ->
            Text(
                text = "Station Detail Stub: $stationId",
                modifier = Modifier
                    .padding(scaffoldPadding),
            )
        },
    )
}
