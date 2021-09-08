package com.timlam.beatandroiders.presentation.ui.components

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timlam.beatandroiders.R
import com.timlam.beatandroiders.presentation.ui.theme.AndroiderYellow

@SuppressLint("UseCompatLoadingForDrawables")
@Composable
fun AndroiderCard(
    title: String,
    subTitle: String,
    profilePicture: Int = R.drawable.ic_launcher_background,
    index: Int = 0,
    leftSidedImage: Boolean = index.rem(2) == 0,
    calculateDominantColor: (Drawable, (Color) -> Unit) -> Unit
) {
    val context = LocalContext.current
    val drawable = context.getDrawable(profilePicture)
    val dominantColor = remember { mutableStateOf(AndroiderYellow) }
    val imageAlignment = remember { if (leftSidedImage) Alignment.CenterStart else Alignment.CenterEnd }
    val dominantColors = when {
        leftSidedImage -> listOf(dominantColor.value, AndroiderYellow)
        else -> listOf(AndroiderYellow, dominantColor.value)
    }


    LaunchedEffect(true) {
        calculateDominantColor(drawable!!) {
            dominantColor.value = it
        }
    }

    AndroiderCard(
        dominantColors = dominantColors,
        imageAlignment = imageAlignment,
        profilePicture = profilePicture,
        index = index,
        title = title,
        subTitle = subTitle
    )
}

@Composable
fun AndroiderCard(
    modifier: Modifier = Modifier,
    height: Dp = 260.dp,
    cornerSize: Dp = 25.dp,
    padding: Dp = 16.dp,
    spacing: Dp = 8.dp,
    backgroundColor: Color = Color.White,
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.h5,
    subtitleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    subTitle: String,
    profilePicture: Int = R.drawable.ic_launcher_background,
    profilePictureDescription: String = "profile picture",
    profilePictureHeight: Dp = 180.dp,
    index: Int = 0,
    indexStyle: TextStyle = titleStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    dominantColors: List<Color> = listOf(AndroiderYellow),
    imageAlignment: Alignment = Alignment.CenterEnd
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(cornerSize))
            .background(backgroundColor)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(profilePictureHeight)
                .clip(RoundedCornerShape(cornerSize))
                .background(Brush.horizontalGradient(dominantColors)),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(imageAlignment),
                painter = painterResource(profilePicture),
                contentDescription = profilePictureDescription,
                contentScale = ContentScale.FillHeight
            )
            Box(
                modifier = Modifier
                    .size(82.dp)
                    .padding(padding)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "#$index",
                    style = indexStyle
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacing)
        )
        Text(
            modifier = Modifier.padding(start = padding),
            text = title,
            style = titleStyle
        )
        Text(
            modifier = Modifier.padding(start = padding),
            text = subTitle,
            style = subtitleStyle
        )
    }
}
