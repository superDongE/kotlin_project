package com.example.soomgo.reciverFragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentRecevieBinding
import com.example.soomgo.reciverFragment.models.ReciverResponse

class ReciverFragment: BaseFragment<FragmentRecevieBinding>(FragmentRecevieBinding::bind,
    R.layout.fragment_recevie
), ReciverView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        ReciverService(this).getReciverList()
    }

    override fun onPostReciverSuccess(response: ReciverResponse) {
        dismissLoadingDialog()

        val list = response.reciverResult
        var adaper = RecevieAdapter(this.context!!, list)
        binding.reciveRecyler.adapter = adaper
        binding.reciveRecyler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.reciveItemTitle.text = "미술 회화 레슨"
        binding.reciveItemDay.text = "2021.01.15"
    }

    override fun onPostReciverFailur(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }
}