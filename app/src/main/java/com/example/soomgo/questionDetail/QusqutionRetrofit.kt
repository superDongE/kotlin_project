package com.example.soomgo.questionDetail

import com.example.soomgo.questionDetail.models.QuestionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QusqutionRetrofit {
    @GET("/question/{category}")
    fun getSearchGosuDetail(@Path("category") category: String): Call<QuestionResponse>
}