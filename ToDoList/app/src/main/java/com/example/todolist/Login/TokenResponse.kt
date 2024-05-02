package com.example.todolist.Login
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token") val token: String
)
