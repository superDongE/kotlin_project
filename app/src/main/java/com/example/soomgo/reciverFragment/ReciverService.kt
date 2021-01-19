package com.example.soomgo.reciverFragment

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.reciverFragment.models.ReciverResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReciverService(val view: ReciverFragment) {
    fun getReciverList() {
        val getReciverService = ApplicationClass.sRetrofit.create(ReciverRetrofit::class.java)
        getReciverService.getReciverData().enqueue(object: Callback<ReciverResponse>{
            override fun onResponse(
                call: Call<ReciverResponse>,
                response: Response<ReciverResponse>
            ) {
                view.onPostReciverSuccess(response.body() as ReciverResponse)
            }

            override fun onFailure(call: Call<ReciverResponse>, t: Throwable) {
                view.onPostReciverFailur(t.message ?: "통신오류")
            }

        })
    }

}