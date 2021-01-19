package com.example.soomgo.english

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.english.models.EngResponse
import com.example.soomgo.study.StudyRetrofit
import com.example.soomgo.study.StudyView
import com.example.soomgo.study.models.StudyRespose
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EngService(val view: EngView) {
    fun tryGetEngList() {
        val enghomservice = ApplicationClass.sRetrofit.create(EngRetrofit::class.java)
        enghomservice.getEng().enqueue(object : Callback<EngResponse> {
            override fun onResponse(
                call: Call<EngResponse>,
                response: Response<EngResponse>
            ) {
                view.onGetEngSuccess(response.body() as EngResponse)

            }

            override fun onFailure(call: Call<EngResponse>, t: Throwable) {
                view.onGetEngFailure(t.message ?: "통신 오류")
            }
        })
    }
}