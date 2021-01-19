package com.example.soomgo.qustionlast.models

import com.google.gson.annotations.SerializedName

data class QuestionLastRepose(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String
)