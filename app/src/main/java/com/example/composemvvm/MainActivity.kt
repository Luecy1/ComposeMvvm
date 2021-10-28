package com.example.composemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*

import com.example.composemvvm.ui.theme.ComposeMvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMvvmTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CountUp()
                }
            }
        }
    }
}

@Composable
fun HelloWorld() {
    Text(text = "Hello World!")
}

@Composable
fun CountUp() {

    // by remember で変化があったときはUIも更新する
    var count by remember {
        mutableStateOf(0)
    }

    Column {
        Text(text = "$count")

        Button(onClick = {
            count++
        }) {
            Text("Count Up")
        }
    }
}