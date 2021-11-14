package com.example.github.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.github.model.repository.NetworkImage
import com.example.github.model.repository.Url
import com.example.github.model.repository.User
import com.example.github.model.repository.UserId
import com.example.github.viewmodel.MainViewModel


@Composable
fun MainView(
    mainViewModel: MainViewModel
) {
    val uiState by mainViewModel.uiState

    Column(Modifier.fillMaxWidth()) {
        SearchView(
            searchQuery = mainViewModel.searchQuery,
            onSearchButtonTapped = mainViewModel::onSearchTapped,
        )

        when (uiState) {
            is MainViewModel.UiState.Initial -> {
                Text("検索してください")
            }
            is MainViewModel.UiState.Loading -> {
                CircularProgressIndicator()
            }
            is MainViewModel.UiState.Success -> {
                val user = (uiState as MainViewModel.UiState.Success).user
                UserDetailView(user = user)
            }
            is MainViewModel.UiState.Failure -> {
                Text("読み込み失敗")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserDetailViewPreview() {
    val user = User(
        name = "aaaa",
        userId = UserId(300L),
        avatarImage = NetworkImage(url = Url("")),
        blogUrl = Url(""),
    )

    UserDetailView(user)
}

@Composable
private fun UserDetailView(user: User) {
    Column {
        Text(text = user.userId.value.toString())
        Text(text = user.name)
        Text(text = user.avatarImage.url.value)
        Text(text = user.blogUrl.value)
    }
}

