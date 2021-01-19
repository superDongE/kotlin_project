package com.example.soomgo.questionDetail

import com.example.soomgo.questionDetail.models.QuestionResponse

interface QuestionView {
    fun onQuestionSuccess(response: QuestionResponse)
    fun onQuestionFailure(message: String)
}