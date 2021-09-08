package com.timlam.beatandroiders.presentation.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.timlam.beatandroiders.R

@Composable
fun AndroiderLikedCard(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    profilePicture: Int = R.drawable.ic_launcher_background,
    index: Int = 0,
    calculateDominantColor: (Drawable, (Color) -> Unit) -> Unit,
    onLikeClicked: () -> Unit
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxSize()
    ) {
        AndroiderCard(
            title = title,
            subTitle = subTitle,
            profilePicture = profilePicture,
            index = index,
            calculateDominantColor = calculateDominantColor
        )
        LikeButton(
            modifier = Modifier.align(
                alignment = Alignment.TopEnd
            )
        ) {
            onLikeClicked()
        }
    }
}
