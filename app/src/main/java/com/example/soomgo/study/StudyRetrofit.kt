package com.example.soomgo.study

import com.example.soomgo.papularity.models.PopularityResponse
import com.example.soomgo.study.models.StudyRespose
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StudyRetrofit  {
    @GET("/categories?upper=1&lower=2")
    fun getStudy() : Call<StudyRespose>
}