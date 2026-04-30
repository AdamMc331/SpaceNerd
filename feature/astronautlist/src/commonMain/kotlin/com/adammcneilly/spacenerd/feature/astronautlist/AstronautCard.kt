package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.InlineIconText
import com.adammcneilly.spacenerd.core.displaymodels.AstronautDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

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
