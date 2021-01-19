package com.example.soomgo.login.models

import com.google.gson.annotations.SerializedName

data class ResultSignIn(
    @SerializedName("userIdx") val userIdx: Int,
    @SerializedName("userName") val userName: String,
    @SerializedName("email") val email: String,
    @SerializedName("profileImage") val profileImage: String

)