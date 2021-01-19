package com.example.soomgo.searchgosuFragment.models

import com.google.gson.annotations.SerializedName

data class GosuListResult(
    @SerializedName("gosuProfileIdx") val gosuProfileIdx: Int,
    @SerializedName("oneLineDescription") val oneLineDescription: String,
    @SerializedName("profileImage") val profileImage: String,
    @SerializedName("userName") val userName: String
    //수정하면 안됌
)