package com.example.todolist.Register.API

import com.example.todolist.DataModel.DataModel
import com.example.todolist.Login.TokenResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("Users/")

    fun getUsers(): Call<List<DataModel>>

    @POST("Users/")
    fun createUsers(@Body Users: DataModel): Call<DataModel>
    object  RetrofitClient {
        private const val BASE_URL = "http://10.0.2.2:8000/"

        // Retrofit instance
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Define AuthService interface
        interface AuthService {
            @POST("auth/login")
            suspend fun login(@Body credentials: DataModel): Response<TokenResponse>
        }

        // Initialize ApiService using Retrofit
        val service: ApiService = retrofit.create(ApiService::class.java)
    }

}

