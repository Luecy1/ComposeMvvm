package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.material.ui.theme.ComposeMvvmTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMvvmTheme {
                val navController = rememberNavController()
                MyNavigation(navController = navController)
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


@Composable
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "top") {
        composable("top") {
            PageListScreen { route ->
                navController.navigate(route)
            }
        }
        composable("BottomBar") {
            BottomBarScreen()
        }
    }
}

@Composable
fun PageListScreen(
    onClick: (String) -> Unit
) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState()),
    ) {

        SCREENS.values().forEach { screen ->
            ClickableText(
                text = AnnotatedString(screen.screenName),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                onClick = {
                    onClick(screen.routeName)
                },
                style = TextStyle(
                    fontSize = 24.sp
                )
            )
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageListScreenPreview() {
    PageListScreen {
    }
}

enum class SCREENS(
    val screenName: String,
    val routeName: String,
) {
    BOTTOM_BAR("BottomBar", "BottomBar"),
}