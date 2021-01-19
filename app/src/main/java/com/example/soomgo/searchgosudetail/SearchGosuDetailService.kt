package com.example.soomgo.searchgosudetail

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.searchgosudetail.models.SearchGosuReponse
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class SearchGosuDetailService(val view: SearchGosuDetailView) {
    fun tryGetSearchGosuDetail(idx: String){
        val searchGosuDetailService = ApplicationClass.sRetrofit.create(SearchGosuDetailRetrofit::class.java)
        searchGosuDetailService.getSearchGosuDetail(idx).enqueue(object : Callback<SearchGosuReponse>{
            override fun onResponse(
                call: Call<SearchGosuReponse>,
                response: Response<SearchGosuReponse>
            ) {
                view.onGetSearchGosuDetailSuccess(response.body() as SearchGosuReponse)
            }

            override fun onFailure(call: Call<SearchGosuReponse>, t: Throwable) {
                view.onGetSearchGosuDetailFailure(t.message ?: "통신오류")
            }

        })
    }
}