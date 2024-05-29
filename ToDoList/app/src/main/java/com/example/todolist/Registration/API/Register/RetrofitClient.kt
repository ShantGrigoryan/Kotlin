package com.example.todolist.Registration.API.Register

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://34.229.180.112:8000/"

    // Retrofit instance
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Initialize ApiService using Retrofit
    val service: ApiService = retrofit.create(ApiService::class.java)
}