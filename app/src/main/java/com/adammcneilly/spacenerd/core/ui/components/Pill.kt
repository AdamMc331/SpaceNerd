package com.adammcneilly.spacenerd.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.shared.ui.theme.SpaceTheme

@Composable
fun Pill(
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.secondary,
    contentColor: Color = MaterialTheme.colorScheme.onSecondary,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Text(
        text = text,
        color = contentColor,
        style = textStyle,
        modifier = modifier
            .background(
                color = containerColor,
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
