package com.example.soomgo.login

import com.example.soomgo.login.models.PostSignInRequest
import com.example.soomgo.login.models.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/sign-in?type=1")
    fun postSignin(@Body params: PostSignInRequest): Call<SignInResponse>
}