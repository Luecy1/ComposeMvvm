package com.example.material.screens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AlertDialogScreen() {

    val openDialog = remember { mutableStateOf(false) }

    Button(onClick = {
        openDialog.value = true
    }) {
        Text(text = "Dialog")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(
                    "AlertDialog"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Preview
@Composable
fun AlertDialogScreenPreview() {
    AlertDialogScreen()
}