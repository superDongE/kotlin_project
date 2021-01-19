package com.example.soomgo.papularity

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentPopularityBinding
import com.example.soomgo.papularity.models.PopularityResponse


class FragmentPopularity : BaseFragment<FragmentPopularityBinding>(
    FragmentPopularityBinding::bind,
    R.layout.fragment_popularity
), PopularityView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        PopularityService(this).tryGetPopularity()

    }

    override fun onGetUserSuccess(response: PopularityResponse) {
        dismissLoadingDialog()
        val list = response.popuarityResult
        var adapter = RecyclerAdapter(this.context!!, list)
        binding.popularrecyle.adapter = adapter
        binding.popularrecyle.layoutManager = GridLayoutManager(this.context, 2)

    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}