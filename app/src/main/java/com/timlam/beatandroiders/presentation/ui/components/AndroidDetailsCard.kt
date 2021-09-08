package com.timlam.beatandroiders.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.timlam.beatandroiders.data.Androider
import com.timlam.beatandroiders.presentation.ui.theme.AndroiderBlack
import com.timlam.beatandroiders.presentation.ui.theme.AndroiderLightGray

@Composable
fun AndroiderDetailsCard(
    modifier: Modifier = Modifier,
    height: Dp = 260.dp,
    cornerSize: Dp = 30.dp,
    padding: Dp = 20.dp,
    nameStyle: TextStyle = MaterialTheme.typography.h5.copy(color = AndroiderBlack),
    titleStyle: TextStyle = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.secondary),
    bodyStyle: TextStyle = MaterialTheme.typography.body1.copy(color = AndroiderLightGray),
    androider: Androider,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(cornerSize))
            .background(MaterialTheme.colors.onSecondary)
            .padding(padding),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${androider.lastName} ${androider.firstName}",
            style = nameStyle
        )
        Text(
            text = androider.title,
            style = titleStyle,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = androider.description,
            style = bodyStyle
        )
        Spacer(modifier = Modifier.height(35.dp))
        AndroiderButton(onClick = onButtonClick)
    }
}
