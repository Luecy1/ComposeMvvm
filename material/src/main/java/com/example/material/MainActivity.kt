package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyNavigation(navController = navController)
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeMvvmTheme {
//        Greeting("Android")
//    }
//}

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

@Composable
fun BottomBar() {
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
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            Button(onClick = {
                navController.navigate("friendslist")
            }) {
                Text("Go to Profile")
            }
//            BottomBar()
        }
        composable("friendslist") {
            Text("friendslist")
        }
    }
}

@Composable
fun PageListScreen() {
    Column(
        Modifier.scrollable(
            orientation = Orientation.Horizontal,
            state = rememberScrollState(),
        ),
    ) {

        repeat(20) {
            Text(
                text = "BottomBar",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                    }
                    .padding(12.dp),
                fontSize = 24.sp,
            )
            Divider()
        }
        Text(
            text = "Go to Profile",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageListScreenPreview() {
    PageListScreen()
}
