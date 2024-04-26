package com.example.todolist.API

import com.example.todolist.DataModel.DataModel
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
