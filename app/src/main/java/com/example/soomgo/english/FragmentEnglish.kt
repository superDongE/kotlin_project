package com.example.soomgo.english

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentEnglishBinding
import com.example.soomgo.english.models.EngResponse



class FragmentEnglish : BaseFragment<FragmentEnglishBinding>(FragmentEnglishBinding::bind,
    R.layout.fragment_english
), EngView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        EngService(this).tryGetEngList()

    }
    override fun onGetEngSuccess(response: EngResponse) {
        dismissLoadingDialog()
        val list = response.engResult
        var adapter = EngRecyclerAdapter(this.context!!, list)
        binding.engRecyle.adapter = adapter
        binding.engRecyle.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.VERTICAL }

    }

    override fun onGetEngFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}