package com.example.soomgo.searchgosuFragment

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.searchgosuFragment.models.GosuListReponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SearchGosuService(val view: SearchgosuFragment) {
    fun tryGetGosuList(){
        val searchGosuService = ApplicationClass.sRetrofit.create(SearchGosuRetrofit::class.java)
        searchGosuService.getSearchGosu().enqueue(object : Callback<GosuListReponses>{
            override fun onResponse(
                call: Call<GosuListReponses>,
                response: Response<GosuListReponses>
            ) {
                view.onReponseSearchSuccess(response.body() as GosuListReponses)
            }

            override fun onFailure(call: Call<GosuListReponses>, t: Throwable) {
                view.onReponseSearchFailure(t.message ?: "통신오류")
            }

        })
    }
}