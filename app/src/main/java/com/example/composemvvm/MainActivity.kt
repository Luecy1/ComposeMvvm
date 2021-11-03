package com.example.composemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {

    private val viewModel = CountViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountUp(viewModel)
        }
    }
}

@Composable
fun HelloWorld() {
    Text(text = "Hello World!")
}

@Composable
fun CountUp(viewModel: CountViewModel) {

    val count by viewModel.count

    Column {
        Text(text = "$count")

        Button(onClick = {
            viewModel.onCountUpTapped()
        }) {
            Text("Count Up")
        }
    }
}