package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
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
            Text(
                text = astronaut.name,
                modifier = modifier,
            )
        },
        size = size,
        modifier = modifier,
    )
}
