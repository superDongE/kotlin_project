package com.example.soomgo.searchgosuFragment

import com.example.soomgo.searchgosuFragment.models.GosuListReponses
import retrofit2.Call
import retrofit2.http.GET

interface SearchGosuRetrofit {
    @GET("/gosu-list")
    fun getSearchGosu(): Call<GosuListReponses>
}