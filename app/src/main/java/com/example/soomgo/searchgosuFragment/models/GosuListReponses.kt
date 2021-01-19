package com.example.soomgo.searchgosuFragment.models

import com.google.gson.annotations.SerializedName

data class GosuListReponses(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<GosuListResult>
)