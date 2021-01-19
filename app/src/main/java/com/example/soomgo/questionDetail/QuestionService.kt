package com.example.soomgo.questionDetail

import com.example.soomgo.config.ApplicationClass
import com.example.soomgo.questionDetail.models.QuestionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionService(val view : QustionDetail) {
    fun tryGetQuestion(category: String){
        val questionServiceRetrofitService = ApplicationClass.sRetrofit.create(QusqutionRetrofit::class.java)
        questionServiceRetrofitService.getSearchGosuDetail(category).enqueue(object :
            Callback<QuestionResponse>{
            override fun onResponse(
                call: Call<QuestionResponse>,
                response: Response<QuestionResponse>
            ) {
                view.onQuestionSuccess(response.body() as QuestionResponse)
            }

            override fun onFailure(call: Call<QuestionResponse>, t: Throwable) {
                view.onQuestionFailure(t.message ?: "통신오류")
            }

        })
    }
}