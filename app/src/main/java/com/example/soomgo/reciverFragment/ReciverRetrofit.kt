package com.example.soomgo.reciverFragment

import retrofit2.Call
import retrofit2.http.GET
import com.example.soomgo.reciverFragment.models.ReciverResponse

interface ReciverRetrofit {
    @GET("/recived-list")
    fun getReciverData() : Call<ReciverResponse>
}