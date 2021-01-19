package com.example.soomgo.searchgosudetail.models

import com.google.gson.annotations.SerializedName

data class SearchGosuReponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val searchGosuResult: SearchGosuResult
)