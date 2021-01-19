package com.example.soomgo.english

import com.example.soomgo.english.models.EngResponse
import retrofit2.Call
import retrofit2.http.GET

interface EngRetrofit {
    @GET("/categories?upper=1&lower=3")
    fun getEng() : Call<EngResponse>
}