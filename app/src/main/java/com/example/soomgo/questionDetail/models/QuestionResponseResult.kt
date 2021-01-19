package com.example.soomgo.questionDetail.models

import com.google.gson.annotations.SerializedName

data class QuestionResponseResult(
    @SerializedName("choice") val choice: String,
    @SerializedName("choiceIdx") val choiceIdx: Int,
    @SerializedName("question") val question: String,
    @SerializedName("questionIdx") val questionIdx: Int
)