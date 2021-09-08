package com.timlam.beatandroiders.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.timlam.beatandroiders.data.AndroidersRepo

class DetailsViewModel : ViewModel() {

    var androiderState: MutableState<AndroiderDetailsViewState> = mutableStateOf(AndroiderDetailsViewState.Loading)
        private set

    fun getAndroiderById(id: Int) {
        androiderState.value = AndroiderDetailsViewState.Success(AndroidersRepo.getAndroiderById(id))
    }

}
