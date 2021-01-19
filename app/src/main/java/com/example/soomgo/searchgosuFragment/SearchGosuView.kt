package com.example.soomgo.searchgosuFragment

import com.example.soomgo.searchgosuFragment.models.GosuListReponses

interface SearchGosuView {

    fun onReponseSearchSuccess(reponse: GosuListReponses)

    fun onReponseSearchFailure(message: String)
}