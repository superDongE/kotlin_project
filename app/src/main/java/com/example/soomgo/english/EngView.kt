package com.example.soomgo.english

import com.example.soomgo.english.models.EngResponse

interface EngView {
    fun onGetEngSuccess(response: EngResponse)

    fun onGetEngFailure(message: String)
}