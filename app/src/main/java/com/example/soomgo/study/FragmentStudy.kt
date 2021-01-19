package com.example.soomgo.study

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentStudyBinding
import com.example.soomgo.study.models.StudyRespose


class FragmentStudy : BaseFragment<FragmentStudyBinding>(FragmentStudyBinding::bind,
    R.layout.fragment_study
), StudyView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        StudyService(this).tryGetStudyList()
    }

    override fun onGetStudySuccess(response: StudyRespose) {
        dismissLoadingDialog()
        val list = response.studyResult
        var adapter = RecyclerAdapter(this.context!!, list)
        binding.studyRecyle.adapter = adapter
        binding.studyRecyle.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.VERTICAL }

    }

    override fun onGetStudyFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}
