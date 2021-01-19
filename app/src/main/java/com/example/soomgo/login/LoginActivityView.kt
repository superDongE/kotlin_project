package com.example.soomgo.login

import com.example.soomgo.login.models.SignInResponse


interface LoginActivityView {
    fun onPostSignInSuccess(response: SignInResponse)

    fun onPostSignInFailure(message: String)
}