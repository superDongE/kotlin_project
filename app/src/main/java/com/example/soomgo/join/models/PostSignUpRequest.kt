package com.example.soomgo.join.models

import com.google.gson.annotations.SerializedName
import retrofit2.http.Header

data class PostSignUpRequest (
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("repassword") val repassword: String
)