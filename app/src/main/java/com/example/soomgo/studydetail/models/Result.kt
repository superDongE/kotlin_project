package com.example.soomgo.studydetail.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("activityGosu") val activityGosu: Int,
    @SerializedName("bottomCategoryIdx") val bottomCategoryIdx: Int,
    @SerializedName("bottomCategoryTitle") val bottomCategoryTitle: String,
    @SerializedName("categoryDescription")  val categoryDescription: String,
    @SerializedName("grade") val grade: Float,
    @SerializedName("requestQuantity") val requestQuantity: Int,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("categoryImage") val categoryImage: String
)