package com.example.soomgo.papularity.models

import com.google.gson.annotations.SerializedName

data class PopularityResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val popuarityResult: ArrayList<PopuarityResult>
)