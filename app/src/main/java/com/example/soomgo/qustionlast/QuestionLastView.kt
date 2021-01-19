package com.example.soomgo.qustionlast

import com.example.soomgo.qustionlast.models.GosuFindResponse
import com.example.soomgo.qustionlast.models.QuestionLastRepose

interface QuestionLastView {
    fun onPostQusestionLastSuccess(reponse: QuestionLastRepose)
    fun onPostQusestionLastFailure(message: String)

    fun onGetGosuSearchSuccess(response: GosuFindResponse)
    fun onGetGosuSearchFailure(message: String)
}