package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.material.ui.theme.ComposeMvvmTheme

class MainActivity : ComponentActivity() {

    private val selectedItem = mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(bottomBar = { BottomBar(selectedItem) }) {
                when (selectedItem.value) {
                    0 -> {
                        Text(text = "0番目")
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
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMvvmTheme {
        Greeting("Android")
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