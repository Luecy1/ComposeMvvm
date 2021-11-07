package com.example.github.model.remote_data_source

interface RemoteDataSource {
    suspend fun getGitHubUser(username: String): GitHubUser
}