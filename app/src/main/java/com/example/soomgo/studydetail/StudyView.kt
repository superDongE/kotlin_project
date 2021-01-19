package com.example.soomgo.studydetail

import com.example.soomgo.studydetail.models.StudyDetailResponse

interface StudyView {
    fun onGetStudySuccess(response: StudyDetailResponse)

    fun onGetStudyFailure(message: String)
}