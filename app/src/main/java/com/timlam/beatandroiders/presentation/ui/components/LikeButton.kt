package com.timlam.beatandroiders.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.timlam.beatandroiders.R
import com.timlam.beatandroiders.presentation.ui.theme.AndroiderRed

@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    padding: Dp = 16.dp,
    paddingTop: Dp = 153.dp,
    paddingEnd: Dp = 30.dp,
    size: Dp = 55.dp,
    color: Color = Color.White,
    tint: Color = AndroiderRed,
    shape: Shape = CircleShape,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .padding(
                top = paddingTop,
                end = paddingEnd
            )
            .size(size)
            .background(
                color = color,
                shape = shape
            )
    ) {
        Icon(
            modifier = Modifier.padding(padding),
            painter = painterResource(R.drawable.heart),
            contentDescription = "Like button",
            tint = tint
        )
    }
}
