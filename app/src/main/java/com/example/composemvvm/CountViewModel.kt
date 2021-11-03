package com.example.composemvvm

import androidx.compose.runtime.mutableStateOf

class CountViewModel {

    val count = mutableStateOf(0)

    fun onCountUpTapped() {
        val currentValue = requireNotNull(count.value)
        count.value = currentValue + 1
    }
}