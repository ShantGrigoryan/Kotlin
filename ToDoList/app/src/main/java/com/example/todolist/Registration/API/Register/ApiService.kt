package com.example.todolist.Registration.API.Register

import com.example.todolist.Registration.API.DataModel.DataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("Users/")

    fun getUsers(): Call<List<DataModel>>

    @POST("Users/")
    fun createUsers(@Body Users: DataModel): Call<DataModel>
}

