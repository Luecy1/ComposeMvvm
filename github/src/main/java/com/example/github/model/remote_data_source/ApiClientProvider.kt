package com.example.github.model.remote_data_source

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

private const val API_END_POINT = "https://api.github.com/"

class ApiClientProvider @Inject constructor() {

    @ExperimentalSerializationApi   // asConverterFactory
    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ApiClient::class.java)
    }
}