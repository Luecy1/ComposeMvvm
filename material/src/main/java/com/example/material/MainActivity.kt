package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.material.screens.BottomBarScreen
import com.example.material.screens.MyButtonScreen
import com.example.material.screens.MyFloatingActionButton
import com.example.material.screens.tutorial.Lesson2Screen
import com.example.material.screens.tutorial.Lesson3Screen
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
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "top") {
        composable("top") {
            PageListScreen { route ->
                navController.navigate(route)
            }
        }
        SCREENS.values().forEach { screen ->
            composable(screen.routeName) {
                screen.transition()
            }
        }
    }
}

@Composable
fun PageListScreen(
    onClick: (String) -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "title") }) }
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            SCREENS.values().forEach { screen ->
                Text(
                    text = screen.routeName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onClick(screen.routeName)
                        }
                        .padding(12.dp),
                    style = TextStyle(
                        fontSize = 24.sp
                    )
                )
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageListScreenPreview() {
    PageListScreen {}
}

enum class SCREENS(
    val routeName: String,
    val transition: @Composable () -> Unit,
) {
    TUTORIAL2("Tutorial2", {
        Lesson2Screen()
    }),
    TUTORIAL3("Tutorial3", {
        Lesson3Screen()
    }),
    BOTTOM_BAR("BottomBar", {
        BottomBarScreen()
    }),
    BUTTON("Button", {
        MyButtonScreen()
    }),
    FLOATING_ACTION_BUTTON("FloatingActionButton", {
        MyFloatingActionButton()
    }),
}