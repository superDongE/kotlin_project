package com.example.soomgo.studydetail.models

import com.google.gson.annotations.SerializedName

data class StudyDetailResponse(
    @SerializedName("result") val result: Result,
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String
)