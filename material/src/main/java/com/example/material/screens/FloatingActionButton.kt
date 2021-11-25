package com.example.material.screens

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.material.ui.theme.ComposeMvvmTheme

@Composable
fun MyFloatingActionButton() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
        }
    ) {}
}

@Preview(showBackground = true)
@Composable
fun MyFloatingActionButtonPreview() {
    ComposeMvvmTheme {
        MyFloatingActionButton()
    }
}