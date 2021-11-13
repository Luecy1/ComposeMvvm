package com.example.github.model.repository

data class User(
    val userId: UserId,
    val name: String,
    val avatarImage: NetworkImage,
    val blogUrl: Url,
)