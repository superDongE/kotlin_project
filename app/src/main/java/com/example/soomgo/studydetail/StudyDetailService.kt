package com.example.soomgo.studydetail

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.studydetail.models.StudyDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudyDetailService(val view: StudyDetailActivity) {
    fun getStudyDetail(index: String){
        val studyRetrofitService = ApplicationClass.sRetrofit.create(StudyRetrofitInterface::class.java)
        studyRetrofitService.getStudyDetail(index).enqueue(object: Callback<StudyDetailResponse> {
            override fun onResponse(call: Call<StudyDetailResponse>, response: Response<StudyDetailResponse>) {
                view.onGetStudySuccess(response.body() as StudyDetailResponse)
            }

            override fun onFailure(call: Call<StudyDetailResponse>, t: Throwable) {
                view.onGetStudyFailure(t.message ?: "통신오류")
            }
        })
    }
}