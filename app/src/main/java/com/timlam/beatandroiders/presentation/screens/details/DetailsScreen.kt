package com.timlam.beatandroiders.presentation.screens.details

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.timlam.beatandroiders.data.Androider
import com.timlam.beatandroiders.presentation.ui.components.AndroiderDetailsCard
import com.timlam.beatandroiders.presentation.ui.components.AndroiderImage
import com.timlam.beatandroiders.presentation.ui.components.ErrorText
import com.timlam.beatandroiders.presentation.ui.components.LoadingIndicator

@Composable
fun DetailsScreen(androiderID: Int, detailsViewModel: DetailsViewModel = viewModel()) {
    val context = LocalContext.current
    val androiderState by remember { detailsViewModel.androiderState }

    LaunchedEffect(true) {
        detailsViewModel.getAndroiderById(androiderID)
    }

    when (androiderState) {
        AndroiderDetailsViewState.Loading -> LoadingIndicator()
        is AndroiderDetailsViewState.Error -> ErrorText(message = (androiderState as AndroiderDetailsViewState.Error).message)
        is AndroiderDetailsViewState.Success -> {
            val androider = (androiderState as AndroiderDetailsViewState.Success).androider
            AndroiderDetails(androider = androider) {
                Toast.makeText(context, androider.hint, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun AndroiderDetails(
    modifier: Modifier = Modifier,
    androider: Androider,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
        AndroiderImage(
            image = androider.image,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 120.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AndroiderDetailsCard(
                androider = androider,
                onButtonClick = onButtonClick
            )
        }
    }
}
