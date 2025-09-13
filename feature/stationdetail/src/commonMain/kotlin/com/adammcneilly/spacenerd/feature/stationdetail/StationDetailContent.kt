package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder
import com.eygraber.compose.placeholder.placeholder

private const val STATION_IMAGE_ASPECT_RATIO = 1.5F
private const val AGENCY_IMAGE_PARENT_RATIO = 0.25F
private const val CREW_CARD_PARENT_RATIO = 0.90F

@Composable
fun StationDetailContent(
    state: StationDetailUiState,
    contentPadding: PaddingValues,
    onEvent: (StationDetailUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            bottom = 16.dp + contentPadding.calculateBottomPadding(),
        ),
        modifier = modifier,
    ) {
        item {
            StationImageStatus(
                state = state,
                contentPadding = contentPadding,
            )
        }

        item {
            StationTitle(state)
        }

        item {
            StationSubtitle(state)
        }

        item {
            Text(
                text = "Agencies",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp),
            )
        }

        item {
            StationAgencies(state)
        }

        item {
            Text(
                text = "Onboard Crew",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp),
            )
        }

        item {
            StationCrew(
                state = state,
                onClick = { crewMember ->
                    val event = StationDetailUiEvent.CrewMemberSelected(crewMember)
                    onEvent.invoke(event)
                },
            )
        }
    }
}

@Composable
private fun StationCrew(
    state: StationDetailUiState,
    onClick: (CrewMemberDisplayModel) -> Unit,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(state.crew) { crewMember ->
            StationCrewMemberCard(
                crewMember = crewMember,
                modifier = Modifier
                    .clickable(
                        onClick = {
                            onClick.invoke(crewMember)
                        },
                    )
                    .fillParentMaxWidth(CREW_CARD_PARENT_RATIO),
            )
        }
    }
}

@Composable
private fun StationAgencies(
    state: StationDetailUiState,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(state.station.agencies) { agency ->
            ImageWrapper(
                image = agency.logo,
                contentDescription = null,
                modifier = Modifier
                    .placeholder(
                        visible = agency.isPlaceholder,
                        shape = CircleShape,
                    )
                    .fillParentMaxWidth(AGENCY_IMAGE_PARENT_RATIO)
                    .aspectRatio(1F),
            )
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun StationTitle(
    state: StationDetailUiState,
) {
    Text(
        text = state.station.name,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.station.isPlaceholder)
            .sharedBounds(
                key = state.station.titleSharedElementKey,
            ),
    )
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun StationSubtitle(
    state: StationDetailUiState,
) {
    Text(
        text = state.station.subtitle,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .padding(top = 4.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.station.isPlaceholder)
            .sharedBounds(
                key = state.station.subtitleSharedElementKey,
            ),
    )
}

@Composable
private fun StationImageStatus(
    state: StationDetailUiState,
    contentPadding: PaddingValues,
) {
    Box {
        StationImage(
            station = state.station,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(STATION_IMAGE_ASPECT_RATIO)
                .sharedElement(
                    key = state.station.imageSharedElementKey,
                ),
        )

        StationStatus(
            station = state.station,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = contentPadding.calculateTopPadding())
                .padding(16.dp)
                .placeholder(
                    visible = state.station.isPlaceholder,
                    color = PlaceholderDefaults.color(
                        contentAlpha = 0.15F,
                    ),
                    shape = CircleShape,
                )
                .sharedElement(
                    key = state.station.statusSharedElementKey,
                ),
        )
    }
}

@Composable
private fun StationImage(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    ImageWrapper(
        image = station.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .placeholder(station.isPlaceholder),
    )
}

@Composable
private fun StationStatus(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Pill(
        text = station.status.label,
        containerColor = station.status.containerColor,
        contentColor = station.status.contentColor,
        textStyle = textStyle,
        modifier = modifier,
    )
}
