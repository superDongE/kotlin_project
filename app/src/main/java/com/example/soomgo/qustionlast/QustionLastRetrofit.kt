package com.example.soomgo.qustionlast

import com.example.soomgo.qustionlast.models.GosuFindResponse
import com.example.soomgo.qustionlast.models.QuestionLastRepose
import com.example.soomgo.qustionlast.models.QustionLastRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QustionLastRetrofit {
    @POST("/request")
    fun postQuestionLast(@Body params: QustionLastRequest) : Call<QuestionLastRepose>

    @GET("gosu-search/:{categoryIdx}")
    fun GetGosuSearch(@Path("categoryIdx") categoryIdx : String): Call<GosuFindResponse>
}