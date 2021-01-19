package com.example.soomgo.join

import android.util.Log
import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.login.models.PostSignInRequest
import com.example.soomgo.join.models.PostSignUpRequest
import com.example.soomgo.join.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JoinService(val view: JoinActivityView) {
    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val joinServiceRetrofitService = ApplicationClass.sRetrofit.create(JoinRetrofitInterface::class.java)
        joinServiceRetrofitService.postSignup(postSignUpRequest).enqueue(object: Callback<SignUpResponse>{
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신오류")
            }

        })
    }

}