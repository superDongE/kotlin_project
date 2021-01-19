package com.example.soomgo.login

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.join.JoinRetrofitInterface
import com.example.soomgo.login.models.PostSignInRequest
import com.example.soomgo.login.models.SignInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivity) {
    fun tryPostSignIn(postSignInRequest: PostSignInRequest){
        val loginServiceRetrofitService = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginServiceRetrofitService.postSignin(postSignInRequest).enqueue(object: Callback<SignInResponse>{
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                view.onPostSignInSuccess(response.body() as SignInResponse)
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                view.onPostSignInFailure(t.message ?: "통신오류")
            }

        })
    }
}