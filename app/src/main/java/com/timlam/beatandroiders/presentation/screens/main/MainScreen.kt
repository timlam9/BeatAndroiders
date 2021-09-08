package com.timlam.beatandroiders.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.timlam.beatandroiders.data.Androider
import com.timlam.beatandroiders.presentation.screens.main.AndroiderListViewState.Error
import com.timlam.beatandroiders.presentation.screens.main.AndroiderListViewState.Loading
import com.timlam.beatandroiders.presentation.screens.main.AndroiderListViewState.Success
import com.timlam.beatandroiders.presentation.ui.components.AndroidersList
import com.timlam.beatandroiders.presentation.ui.components.ErrorText
import com.timlam.beatandroiders.presentation.ui.components.LoadingIndicator

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel(), onItemClick: (Androider) -> Unit) {
    val androiderListViewState by remember { mainViewModel.state }

    when (androiderListViewState) {
        Loading -> LoadingIndicator()
        is Error -> ErrorText(message = (androiderListViewState as Error).message)
        is Success -> {
            val androiders = (androiderListViewState as Success).items

            AndroidersList(
                androiders = androiders,
                onItemClicked = { androider -> onItemClick(androider) }
            ) { drawable, onFinish ->
                mainViewModel.calculateDominantColor(drawable = drawable) {
                    onFinish(it)
                }
            }
        }
    }
}
