package com.example.material

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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

@Composable
fun BottomBar(selectedItem: MutableState<Int>) {
    val items = listOf("Songs", "Artists", "Playlists")
    val iconList = arrayOf(Icons.Filled.Favorite, Icons.Filled.Star, Icons.Filled.Build)

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(iconList[index], contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}