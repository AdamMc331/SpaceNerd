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
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.eygraber.compose.placeholder.material3.placeholder

private const val COMPACT_CARD_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun ImageContentCard(
    image: ImageModel,
    title: String,
    subtitle: String?,
    placeholder: Boolean,
    transitionKeyPrefix: String,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowWidthSizeClass() in listOf(
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
    )

    if (isAtLeastMediumWidth) {
        MediumExpandedCard(
            image = image,
            title = title,
            subtitle = subtitle,
            placeholder = placeholder,
            transitionKeyPrefix = transitionKeyPrefix,
            modifier = modifier,
        )
    } else {
        CompactCard(
            image = image,
            title = title,
            subtitle = subtitle,
            placeholder = placeholder,
            transitionKeyPrefix = transitionKeyPrefix,
            modifier = modifier,
        )
    }
}

@Composable
private fun MediumExpandedCard(
    image: ImageModel,
    title: String,
    subtitle: String?,
    placeholder: Boolean,
    transitionKeyPrefix: String,
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
                image = image,
                transitionKeyPrefix = transitionKeyPrefix,
                placeholder = placeholder,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            Column {
                CardContent(
                    title,
                    subtitle,
                    transitionKeyPrefix,
                    placeholder,
                )
            }
        }
    }
}

@Composable
private fun CompactCard(
    image: ImageModel,
    title: String,
    subtitle: String?,
    placeholder: Boolean,
    transitionKeyPrefix: String,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                CardImage(
                    image = image,
                    transitionKeyPrefix,
                    placeholder,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(COMPACT_CARD_IMAGE_ASPECT_RATIO),
                )
            }

            CardContent(
                title = title,
                subtitle = subtitle,
                transitionKeyPrefix = transitionKeyPrefix,
                placeholder = placeholder,
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
