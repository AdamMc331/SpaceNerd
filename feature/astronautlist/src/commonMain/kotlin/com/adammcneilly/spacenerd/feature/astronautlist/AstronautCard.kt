package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.InlineIconText
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.CountryDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.AstronautStatus
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder
import com.eygraber.compose.placeholder.placeholder

@Composable
fun AstronautCard(
    astronaut: AstronautDisplayModel,
    size: ImageContentCard.Size,
    modifier: Modifier = Modifier,
) {
    ImageContentCard(
        image = { modifier ->
            ImageWrapper(
                image = astronaut.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .placeholder(astronaut.placeholder),
            )
        },
        status = { modifier ->
            AstronautStatus(
                size = size,
                astronaut = astronaut,
                modifier = modifier,
            )
        },
        content = { modifier ->
            Column(
                modifier = modifier,
            ) {
                AstronautName(astronaut)

                AstronautBio(astronaut)

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                )

                AstronautAgency(astronaut)

                AstronautNationalities(astronaut)
            }
        },
        size = size,
        modifier = modifier,
    )
}

@Composable
private fun AstronautStatus(
    size: ImageContentCard.Size,
    astronaut: AstronautDisplayModel,
    modifier: Modifier,
) {
    val placeholderColor = if (size == ImageContentCard.Size.Compact) {
        PlaceholderDefaults.color(
            contentAlpha = 0.15F,
        )
    } else {
        PlaceholderDefaults.color()
    }

    Pill(
        text = astronaut.status.label,
        containerColor = astronaut.status.containerColor,
        contentColor = astronaut.status.contentColor,
        modifier = modifier
            .placeholder(
                visible = astronaut.placeholder,
                shape = CircleShape,
                color = placeholderColor,
            ),
    )
}

@Composable
private fun AstronautBio(
    astronaut: AstronautDisplayModel,
) {
    Text(
        text = astronaut.bio,
        style = MaterialTheme.typography.bodySmall,
        maxLines = 3,
        modifier = Modifier
            .padding(top = 4.dp)
            .placeholder(astronaut.placeholder),
    )
}

@Composable
private fun AstronautName(
    astronaut: AstronautDisplayModel,
) {
    Text(
        text = astronaut.name,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier
            .placeholder(astronaut.placeholder),
    )
}

@Composable
private fun AstronautAgency(
    astronaut: AstronautDisplayModel,
) {
    val agency = astronaut.agency

    if (agency != null) {
        InlineIconText(
            text = agency.name,
            icon = Icons.Default.CorporateFare,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .placeholder(agency.isPlaceholder),
        )
    }
}

@Composable
private fun AstronautNationalities(
    astronaut: AstronautDisplayModel,
) {
    val nationalities = astronaut.nationalities
    if (nationalities.isNotEmpty()) {
        val names = nationalities.joinToString(transform = CountryDisplayModel::name)

        InlineIconText(
            text = names,
            icon = Icons.Default.Public,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(astronaut.placeholder),
        )
    }
}
