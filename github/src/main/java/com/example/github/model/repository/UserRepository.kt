package com.example.github.model.repository

interface UserRepository {
    suspend fun getUser(userName: String): User
}