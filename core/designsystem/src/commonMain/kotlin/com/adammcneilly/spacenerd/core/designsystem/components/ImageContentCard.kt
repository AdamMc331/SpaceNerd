package com.adammcneilly.spacenerd.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

private const val COMPACT_CARD_IMAGE_ASPECT_RATIO = 1.5F

/**
 * This is a container for all of the components that make up an `ImageContentCard`.
 *
 * @property Size The possible sizes for an `ImageContentCard`, which will render the content
 * in different ways.
 */
object ImageContentCard {
    /**
     * Defines the various sizes that an `ImageContentCard` can be rendered in.
     */
    enum class Size {
        Compact,
        Expanded,
    }
}

@Composable
fun ImageContentCard(
    image: @Composable (Modifier) -> Unit,
    status: @Composable (Modifier) -> Unit,
    content: @Composable (Modifier) -> Unit,
    size: ImageContentCard.Size,
    modifier: Modifier = Modifier,
) {
    when (size) {
        ImageContentCard.Size.Compact -> {
            CompactCard(
                image = image,
                status = status,
                content = content,
                modifier = modifier,
            )
        }

        ImageContentCard.Size.Expanded -> {
            ExpandedCard(
                image = image,
                status = status,
                content = content,
                modifier = modifier,
            )
        }
    }
}

@Composable
private fun CompactCard(
    image: @Composable (Modifier) -> Unit,
    status: @Composable (Modifier) -> Unit,
    content: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                image(
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(COMPACT_CARD_IMAGE_ASPECT_RATIO),
                )

                status(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp),
                )
            }

            content(
                Modifier
                    .padding(16.dp),
            )
        }
    }
}

@Composable
private fun ExpandedCard(
    image: @Composable (Modifier) -> Unit,
    status: @Composable (Modifier) -> Unit,
    content: @Composable (Modifier) -> Unit,
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
            image(
                Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            Column {
                content(
                    Modifier,
                )

                CompositionLocalProvider(
                    LocalTextStyle provides MaterialTheme.typography.labelSmall,
                ) {
                    status(
                        Modifier
                            .padding(top = 4.dp),
                    )
                }
            }
        }
    }
}
