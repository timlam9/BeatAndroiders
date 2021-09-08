package com.timlam.beatandroiders.presentation.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AndroiderButton(
    modifier: Modifier = Modifier,
    height: Dp = 60.dp,
    color: Color = MaterialTheme.colors.onSecondary,
    backgroundColor: Color = MaterialTheme.colors.secondary,
    text: String = "Say something",
    textStyle: TextStyle = MaterialTheme.typography.button,
    shape: Shape = RoundedCornerShape(50),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(height = height),
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}
