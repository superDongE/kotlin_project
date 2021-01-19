package com.example.soomgo.login.models

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("jwt") val jwt: String,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ResultSignIn
)