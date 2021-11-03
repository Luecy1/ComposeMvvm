package com.example.composemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountUp()
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