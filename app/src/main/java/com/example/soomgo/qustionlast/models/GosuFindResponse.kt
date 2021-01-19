package com.example.soomgo.qustionlast.models

import com.google.gson.annotations.SerializedName

data class GosuFindResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<GosuFindResponseResult>
)