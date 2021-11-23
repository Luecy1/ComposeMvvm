package com.example.material.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material.ui.theme.ComposeMvvmTheme

@Composable
fun MyButtonScreen() {
    val context = LocalContext.current
    val buttonText = remember { mutableStateOf("Button") }
    var checked by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CommonSpacer()

        Button(onClick = {
            buttonText.value = "clicked!"
        }) {
            Text(buttonText.value)
        }

        CommonSpacer()

        OutlinedButton(onClick = {
            Toast.makeText(context, "OutlinedButton", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "OutlinedButton")
        }

        CommonSpacer()

        TextButton(onClick = {
            Toast.makeText(context, "TextButton", Toast.LENGTH_SHORT).show()
        }) {
            Text("TextButton")
        }

        CommonSpacer()

        IconButton(onClick = {
            Toast.makeText(context, "IconButton", Toast.LENGTH_SHORT).show()
        }) {
            Icon(Icons.Outlined.Favorite, contentDescription = "Localized description")
        }

        CommonSpacer()

        IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
            val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description", tint = tint)
        }
    }
}

@Composable
private fun CommonSpacer() {
    Spacer(modifier = Modifier.height(20.dp))
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MyButtonScreenPreview() {
    ComposeMvvmTheme {
        MyButtonScreen()
    }
}