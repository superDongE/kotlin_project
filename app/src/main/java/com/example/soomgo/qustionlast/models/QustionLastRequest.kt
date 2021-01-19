package com.example.soomgo.qustionlast.models

import com.google.gson.annotations.SerializedName

data class QustionLastRequest(
    @SerializedName("categoryIdx") val categoryIdx: Int,
    @SerializedName("firstQuestion") val firstQuestion: Int,
    @SerializedName("firstAnswer") val firstAnswer: Int,
    @SerializedName("secondQuestion") val secondQuestion: Int,
    @SerializedName("secondAnswer") val secondAnswer: Int,
    @SerializedName("thirdQuestion") val thirdQuestion: Int,
    @SerializedName("thirdAnswer") val thirdAnswer: Int,
    @SerializedName("fourthQuestion") val fourthQuestion: Int,
    @SerializedName("userRegion") val userRegion: String
)
