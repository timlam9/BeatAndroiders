package com.timlam.beatandroiders.presentation.screens.details

import com.timlam.beatandroiders.data.Androider

sealed class AndroiderDetailsViewState {

    object Loading : AndroiderDetailsViewState()

    data class Error(val message: String) : AndroiderDetailsViewState()

    data class Success(val androider: Androider) : AndroiderDetailsViewState()

}
