package com.example.soomgo.papularity

import com.example.soomgo.papularity.models.PopularityResponse

interface PopularityView {
    fun onGetUserSuccess(response: PopularityResponse)

    fun onGetUserFailure(message: String)

}