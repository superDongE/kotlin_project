package com.example.soomgo.searchgosudetail

import com.example.soomgo.searchgosudetail.models.SearchGosuReponse

interface SearchGosuDetailView {

    fun onGetSearchGosuDetailSuccess(response: SearchGosuReponse)

    fun onGetSearchGosuDetailFailure(message: String)
}