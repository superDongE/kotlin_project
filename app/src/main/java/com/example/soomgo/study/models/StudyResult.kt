package com.example.soomgo.study.models

import com.google.gson.annotations.SerializedName

data class StudyResult(
    @SerializedName("bottomCategoryIdx") val bottomCategoryIdx: Int,
    @SerializedName("bottomCategoryTitle") val bottomCategoryTitle: String
)