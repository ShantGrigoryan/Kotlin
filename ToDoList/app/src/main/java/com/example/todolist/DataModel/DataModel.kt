package com.example.todolist.DataModel

import com.google.gson.annotations.SerializedName


data class DataModel(
    @SerializedName("username") val username : String,
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
)

