package com.example.soomgo.english.models

import com.google.gson.annotations.SerializedName

data class EngResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val engResult: ArrayList<EngResult>
)