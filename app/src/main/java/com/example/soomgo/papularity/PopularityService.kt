package com.example.soomgo.papularity

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.papularity.models.PopularityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularityService(val view: PopularityView) {

    fun tryGetPopularity() {
        val popularityService = ApplicationClass.sRetrofit.create(PopularityRetrofit::class.java)
        popularityService.getPopularity().enqueue(object : Callback<PopularityResponse>{
            override fun onResponse(
                call: Call<PopularityResponse>,
                response: Response<PopularityResponse>
            ) {
                view.onGetUserSuccess(response.body() as PopularityResponse)

            }

            override fun onFailure(call: Call<PopularityResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }
}