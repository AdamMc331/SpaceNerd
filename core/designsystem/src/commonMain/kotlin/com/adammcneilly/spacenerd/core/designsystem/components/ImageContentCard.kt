package com.adammcneilly.spacenerd.core.designsystem.components

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val COMPACT_CARD_IMAGE_ASPECT_RATIO = 1.5F

data class ImageContentCardConfig(
    val image: ImageModel,
    val title: String,
    val subtitle: String?,
    val placeholder: Boolean,
    val transitionKeyPrefix: String,
    val status: StatusConfig?,
) {
    data class StatusConfig(
        val text: String,
        val contentColor: Color,
        val containerColor: Color,
    )
}

@Composable
fun ImageContentCard(
    config: ImageContentCardConfig,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowWidthSizeClass() in listOf(
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
    )

    if (isAtLeastMediumWidth) {
        MediumExpandedCard(
            config = config,
            modifier = modifier,
        )
    } else {
        CompactCard(
            config = config,
            modifier = modifier,
        )
    }
}

@Composable
private fun MediumExpandedCard(
    config: ImageContentCardConfig,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp),
        ) {
            CardImage(
                image = config.image,
                transitionKeyPrefix = config.transitionKeyPrefix,
                placeholder = config.placeholder,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            Column {
                CardContent(
                    title = config.title,
                    subtitle = config.subtitle,
                    transitionKeyPrefix = config.transitionKeyPrefix,
                    placeholder = config.placeholder,
                )

                if (config.status != null) {
                    Pill(
                        text = config.status.text,
                        containerColor = config.status.containerColor,
                        contentColor = config.status.contentColor,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .placeholder(
                                visible = config.placeholder,
                                shape = CircleShape,
                            ),
                    )
                }
            }
        }
    }
}

@Composable
private fun CompactCard(
    config: ImageContentCardConfig,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                CardImage(
                    image = config.image,
                    transitionKeyPrefix = config.transitionKeyPrefix,
                    placeholder = config.placeholder,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(COMPACT_CARD_IMAGE_ASPECT_RATIO),
                )

                if (config.status != null) {
                    Pill(
                        text = config.status.text,
                        containerColor = config.status.containerColor,
                        contentColor = config.status.contentColor,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .placeholder(
                                visible = config.placeholder,
                                color = PlaceholderDefaults.color(
                                    contentAlpha = 0.15F,
                                ),
                                shape = CircleShape,
                            ),
                    )
                }
            }

            CardContent(
                title = config.title,
                subtitle = config.subtitle,
                transitionKeyPrefix = config.transitionKeyPrefix,
                placeholder = config.placeholder,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun CardContent(
    title: String,
    subtitle: String?,
    transitionKeyPrefix: String,
    placeholder: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .placeholder(placeholder)
                .sharedBounds("$transitionKeyPrefix-Title"),
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .placeholder(placeholder)
                    .sharedBounds("$transitionKeyPrefix-Subtitle"),
            )
        }
    }
}

@Composable
private fun CardImage(
    image: ImageModel,
    transitionKeyPrefix: String,
    placeholder: Boolean,
    modifier: Modifier = Modifier,
) {
    ImageWrapper(
        image = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .placeholder(placeholder)
            .sharedElement(
                key = "$transitionKeyPrefix-Image",
            ),
    )
}
