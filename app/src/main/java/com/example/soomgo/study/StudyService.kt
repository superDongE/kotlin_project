package com.example.soomgo.study

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.papularity.PopularityView
import com.example.soomgo.study.models.StudyRespose
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudyService(val view: StudyView) {
    fun tryGetStudyList() {
        val studyhomservice = ApplicationClass.sRetrofit.create(StudyRetrofit::class.java)
        studyhomservice.getStudy().enqueue(object : Callback<StudyRespose> {
            override fun onResponse(
                call: Call<StudyRespose>,
                response: Response<StudyRespose>
            ) {
                view.onGetStudySuccess(response.body() as StudyRespose)

            }

            override fun onFailure(call: Call<StudyRespose>, t: Throwable) {
                view.onGetStudyFailure(t.message ?: "통신 오류")
            }
        })
    }
}