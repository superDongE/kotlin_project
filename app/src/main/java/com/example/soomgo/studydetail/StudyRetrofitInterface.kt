package com.example.soomgo.studydetail

import com.example.soomgo.studydetail.models.StudyDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudyRetrofitInterface {
    @GET("category/{index}")
    fun getStudyDetail(@Path("index") index: String): Call<StudyDetailResponse>
}