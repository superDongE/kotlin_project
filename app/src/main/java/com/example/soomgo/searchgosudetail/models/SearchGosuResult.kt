package com.example.soomgo.searchgosudetail.models

import com.google.gson.annotations.SerializedName

data class SearchGosuResult(
    @SerializedName("activityRadius") val activityRadius: String,
    @SerializedName("activityRegion") val activityRegion: String,
    @SerializedName("authentication") val authentication: String,
    @SerializedName("carrer") val carrer: String,
    @SerializedName("contactTime") val contactTime: String,
    @SerializedName("detailDescription") val detailDescription: String,
    @SerializedName("gosuProfileIdx") val gosuProfileIdx: Int,
    @SerializedName("mainCategory") val mainCategory: String,
    @SerializedName("numberOfEmployees") val numberOfEmployees: String,
    @SerializedName("oneLineDescription") val oneLineDescription: String,
    @SerializedName("profileImage") val profileImage: String,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("reviewGrade") val reviewGrade: Float,
    @SerializedName("selectCategory") val selectCategory: String,
    @SerializedName("userName") val userName: String
)