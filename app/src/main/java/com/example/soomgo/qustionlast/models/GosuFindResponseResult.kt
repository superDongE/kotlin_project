package com.example.soomgo.qustionlast.models

import com.google.gson.annotations.SerializedName

data class GosuFindResponseResult(
    @SerializedName("categoryIdx")val categoryIdx: Int,
    @SerializedName("gosuProfileIdx")val gosuProfileIdx: Int,
    @SerializedName("profileImage") val profileImage: String,
    @SerializedName("requestIdx")val requestIdx: Int,
    @SerializedName("userIdx")val userIdx: Int
)