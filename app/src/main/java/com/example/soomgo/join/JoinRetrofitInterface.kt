package com.example.soomgo.join

import com.example.soomgo.login.models.PostSignInRequest
import com.example.soomgo.join.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.soomgo.join.models.PostSignUpRequest
import com.example.soomgo.login.models.SignInResponse

interface JoinRetrofitInterface {
    @POST("/sign-up?type=1")
    fun postSignup(@Body params: PostSignUpRequest): Call<SignUpResponse>


}