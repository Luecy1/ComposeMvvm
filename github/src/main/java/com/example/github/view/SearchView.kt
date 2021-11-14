package com.example.github.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchView(
    searchQuery: MutableState<String>,
    onSearchButtonTapped: () -> Unit,
) {

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            label = {
                Text("Githubアカウントを入力")
            },
            value = searchQuery.value,
            onValueChange = { text ->
                searchQuery.value = text
            },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            onSearchButtonTapped()
        }) {
            Text(text = "検索")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchView() {
    val searchQuery = remember { mutableStateOf("") }
    SearchView(searchQuery = searchQuery) {

    }
}