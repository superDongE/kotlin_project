package com.example.soomgo.study

import com.example.soomgo.study.models.StudyRespose


interface StudyView {
    fun onGetStudySuccess(response: StudyRespose)

    fun onGetStudyFailure(message: String)
}