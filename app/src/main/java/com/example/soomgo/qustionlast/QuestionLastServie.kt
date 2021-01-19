package com.example.soomgo.qustionlast

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.qustionlast.models.GosuFindResponse
import com.example.soomgo.qustionlast.models.QuestionLastRepose
import com.example.soomgo.qustionlast.models.QustionLastRequest
import com.example.soomgo.searchgosuFragment.models.GosuListReponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionLastServie(val view: QuestionLastActivity) {
    fun tryPostQustionLast(postQuestionLast: QustionLastRequest){
        val postQuestionLastService = ApplicationClass.sRetrofit.create(QustionLastRetrofit::class.java)
        postQuestionLastService.postQuestionLast(postQuestionLast).enqueue(object:
            Callback<QuestionLastRepose>{
            override fun onResponse(
                call: Call<QuestionLastRepose>,
                response: Response<QuestionLastRepose>
            ) {
                view.onPostQusestionLastSuccess(response.body() as QuestionLastRepose)
            }

            override fun onFailure(call: Call<QuestionLastRepose>, t: Throwable) {
                view.onPostQusestionLastFailure(t.message ?: "통신오류")
            }

        })
    }

    fun tryGetGosuSearch(idx: String){
        val trySearchGosu = ApplicationClass.sRetrofit.create(QustionLastRetrofit::class.java)
        trySearchGosu.GetGosuSearch(idx).enqueue(object: Callback<GosuFindResponse>{
            override fun onResponse(
                call: Call<GosuFindResponse>,
                response: Response<GosuFindResponse>
            ) {
                view.onGetGosuSearchSuccess(response.body() as GosuFindResponse)
            }

            override fun onFailure(call: Call<GosuFindResponse>, t: Throwable) {
                view.onGetGosuSearchFailure(t.message ?: "통신오류")
            }
        })
    }
}