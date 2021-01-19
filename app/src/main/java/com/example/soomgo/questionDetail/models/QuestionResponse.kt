package com.example.soomgo.questionDetail.models

import com.google.gson.annotations.SerializedName

data class QuestionResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<QuestionResponseResult>
)