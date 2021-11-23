package com.example.material

import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun BottomBarScreen() {
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(bottomBar = { BottomBar(selectedItem) }) {
        when (selectedItem.value) {
            0 -> {
                Card {
                    Text("Card Content")
                }
            }
            1 -> {
                Text(text = "1番目")
            }
            2 -> {
                Text(text = "2番目")
            }
        }
    }
}