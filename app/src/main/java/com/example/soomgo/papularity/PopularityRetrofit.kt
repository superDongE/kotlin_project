package com.example.soomgo.papularity

import com.example.soomgo.papularity.models.PopularityResponse
import retrofit2.Call
import retrofit2.http.GET

interface PopularityRetrofit {
    @GET("/categories?upper=1&lower=1")
    fun getPopularity() : Call<PopularityResponse>
}