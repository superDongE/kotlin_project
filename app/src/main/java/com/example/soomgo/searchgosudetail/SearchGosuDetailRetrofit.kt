package com.example.soomgo.searchgosudetail

import com.example.soomgo.searchgosudetail.models.SearchGosuReponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchGosuDetailRetrofit {
    @GET("/gosu-profile/{idx}")
    fun getSearchGosuDetail(@Path("idx") idx: String): Call<SearchGosuReponse>
}