package com.adammcneilly.spacenerd.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.adammcneilly.spacenerd.shared.core.displaymodels.ImageDisplayModel
import org.jetbrains.compose.resources.painterResource

/**
 * Wrapper around an [image] that will render the correct component
 * based on the image type.
 */
@Composable
fun ImageWrapper(
    image: ImageDisplayModel,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    when (image) {
        is ImageDisplayModel.Local -> {
            LocalImage(
                image = image,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = modifier,
            )
        }

        is ImageDisplayModel.Remote -> {
            RemoteImage(
                image = image,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = modifier,
            )
        }

        is ImageDisplayModel.Placeholder -> {
            PlaceholderImage(modifier)
        }
        else -> {
            // No-Op
        }
    }
}

@Composable
private fun RemoteImage(
    image: ImageDisplayModel.Remote,
    contentDescription: String?,
    contentScale: ContentScale,
    modifier: Modifier,
) {
    AsyncImage(
        model = image.url,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}

@Composable
private fun LocalImage(
    image: ImageDisplayModel.Local,
    contentDescription: String?,
    contentScale: ContentScale,
    modifier: Modifier,
) {
    Image(
        painter = painterResource(image.resource),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}

@Composable
private fun PlaceholderImage(
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.outline,
            ),
    )
}
