package com.example.soomgo.homeFragment.models

import android.content.Context

data class HomeServiceData(
    val name: String,
    val img: String
){
    fun getImageId(context: Context): Int {
        return context.resources.getIdentifier(img, "drawable", context.packageName)
    }
}
