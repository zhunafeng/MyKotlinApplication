package com.example.mykotlinapplication.features.failure

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FailureViewModel : ViewModel() {

    /** The current state of the UI */
    val uiState = mutableStateOf(FailureScreen.UiState.SHOW_FAILURE)

    fun showHome() {
        // uiState.value =
    }
}