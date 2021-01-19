package com.example.soomgo.reciverFragment.models

import com.google.gson.annotations.SerializedName

data class ReciverResult(
    @SerializedName("bottomCategoryTitle") val bottomCategoryTitle: String,
    @SerializedName("dateTime") val dateTime: String,
    @SerializedName("estimateIdx") val estimateIdx: Int,
    @SerializedName("profileImage") val profileImage: String,
    @SerializedName("requestIdx") val requestIdx: Int
)