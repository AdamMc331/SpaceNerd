package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CorporateFare
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
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
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
        status = {},
        content = { modifier ->
            Column(
                modifier = modifier,
            ) {
                Text(
                    text = astronaut.name,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .placeholder(astronaut.placeholder),
                )

                Text(
                    text = astronaut.bio,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .placeholder(astronaut.placeholder),
                )

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                )

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
        },
        size = size,
        modifier = modifier,
    )
}
