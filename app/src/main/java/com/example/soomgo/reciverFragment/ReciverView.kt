package com.example.soomgo.reciverFragment

import android.telecom.Call
import com.example.soomgo.reciverFragment.models.ReciverResponse
import retrofit2.http.GET

interface ReciverView {
    fun onPostReciverSuccess(response: ReciverResponse)
    fun onPostReciverFailur(message: String)
}