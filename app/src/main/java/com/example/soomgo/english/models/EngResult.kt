package com.example.soomgo.english.models

import com.google.gson.annotations.SerializedName

data class EngResult(
    @SerializedName("bottomCategoryIdx") val bottomCategoryIdx: Int,
    @SerializedName("bottomCategoryTitle") val bottomCategoryTitle: String
)