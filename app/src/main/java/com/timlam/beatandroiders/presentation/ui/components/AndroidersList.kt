package com.timlam.beatandroiders.presentation.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timlam.beatandroiders.data.Androider
import com.timlam.beatandroiders.presentation.ui.theme.Typography

@Composable
fun AndroidersList(
    modifier: Modifier = Modifier,
    title: String = "Beat Androiders",
    titleStyle: TextStyle = Typography.h5.copy(
        fontSize = 32.sp,
        color = MaterialTheme.colors.onBackground
    ),
    androiders: List<Androider> = emptyList(),
    padding: Dp = 16.dp,
    onItemClicked: (Androider) -> Unit,
    calculateDominantColor: (Drawable, (Color) -> Unit) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = padding,
                end = padding
            )
    ) {
        item {
            Text(
                modifier = Modifier.padding(padding),
                text = title,
                style = titleStyle
            )
        }
        itemsIndexed(androiders) { index, androider ->
            AndroiderLikedCard(
                modifier = Modifier.clickable { onItemClicked(androider) },
                title = "${androider.lastName} ${androider.firstName}",
                subTitle = androider.title,
                profilePicture = androider.image,
                index = index + 1,
                calculateDominantColor = calculateDominantColor
            ) {

            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            )
        }
    }
}
