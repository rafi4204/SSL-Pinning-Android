package com.example.sslpinning.network

import com.example.sslpinning.ui.User
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.github.com/"


private val certPinner = CertificatePinner.Builder()
    .add("api.github.com", "sha256/uyPYgclc5Jt69vKu92vci6etcBDY8UNTyrHQZJpVoZY=")
    .build()


private fun setupInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = (HttpLoggingInterceptor.Level.BASIC)
    return logging
}


private val okHttpClient = OkHttpClient.Builder()
    .certificatePinner(certPinner)
    .addInterceptor(setupInterceptor())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()


object GithubApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
