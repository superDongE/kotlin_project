package com.example.soomgo.join


import com.example.soomgo.join.models.SignUpResponse

interface JoinActivityView {

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}