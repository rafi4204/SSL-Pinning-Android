package com.example.sslpinning.network

import com.example.sslpinning.ui.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{profile}")
    suspend fun getUserData(@Path("profile") profile: String): Response<User>
}
