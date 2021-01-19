package com.example.soomgo.reciverFragment.models

import com.google.gson.annotations.SerializedName

data class ReciverResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val reciverResult: ArrayList<ReciverResult>
)