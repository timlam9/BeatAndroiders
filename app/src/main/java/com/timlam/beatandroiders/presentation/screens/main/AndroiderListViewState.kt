package com.timlam.beatandroiders.presentation.screens.main

import com.timlam.beatandroiders.data.Androider

sealed class AndroiderListViewState {

    object Loading : AndroiderListViewState()

    data class Error(val message: String) : AndroiderListViewState()

    data class Success(val items: List<Androider>) : AndroiderListViewState()

}
