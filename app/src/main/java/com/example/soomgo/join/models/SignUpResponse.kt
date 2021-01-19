package com.example.soomgo.join.models

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("jwt") val jwt: String
)