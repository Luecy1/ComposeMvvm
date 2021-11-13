package com.example.github.model.repository

import com.example.github.model.remote_data_source.GitHubUser
import com.example.github.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : UserRepository {

    override suspend fun getUser(userName: String): User {
        return remoteDataSource.getGitHubUser(userName).toUser()
    }
}

private fun GitHubUser.toUser(): User {
    return User(
        userId = UserId(id),
        name = this.name,
        avatarImage = NetworkImage(Url(avatarUrl)),
        blogUrl = Url(this.blog),
    )
}
