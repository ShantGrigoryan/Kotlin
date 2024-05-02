package com.example.todolist.Login

import com.example.todolist.DataModel.DataModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body credentials: DataModel): Response<TokenResponse>
}
