package com.example.soomgo.study.models

import com.google.gson.annotations.SerializedName

data class StudyRespose(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val studyResult: ArrayList<StudyResult>
)