package com.example.composemvvm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    val count = mutableStateOf(0)

    fun onCountUpTapped() {
        val currentValue = requireNotNull(count.value)
        count.value = currentValue + 1
    }
}