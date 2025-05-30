package com.adammcneilly.spacenerd.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.scaffold.ui.theme.SpaceTheme

@Composable
fun Pill(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = MaterialTheme.colorScheme.onSecondary,
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier
            .background(
                color = color,
                shape = CircleShape,
            )
            .padding(
                horizontal = 8.dp,
            ),
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun PillPreview() {
    SpaceTheme {
        Pill(
            text = "GO",
        )
    }
}
