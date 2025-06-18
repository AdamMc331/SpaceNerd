package com.adammcneilly.spacenerd.shared.ui.components

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
import androidx.compose.ui.unit.dp

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
