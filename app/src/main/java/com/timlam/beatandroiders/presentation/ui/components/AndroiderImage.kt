package com.timlam.beatandroiders.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AndroiderImage(
    modifier: Modifier = Modifier,
    size: Dp = 220.dp,
    image: Int,
    description: String = "profile image",
    shape: Shape = RoundedCornerShape(30)
) {
    Image(
        modifier = modifier
            .size(size)
            .clip(shape),
        painter = painterResource(image),
        contentDescription = description,
        contentScale = ContentScale.Crop
    )
}
