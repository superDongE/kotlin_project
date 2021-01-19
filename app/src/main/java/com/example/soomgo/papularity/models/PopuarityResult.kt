package com.example.soomgo.papularity.models

import com.google.gson.annotations.SerializedName

data class PopuarityResult(
    @SerializedName("bottomCategoryIdx") val bottomCategoryIdx: Int,
    @SerializedName("bottomCategoryTitle") val bottomCategoryTitle: String,
    @SerializedName("popularImage") val popularImage: String
)