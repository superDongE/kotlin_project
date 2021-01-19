package com.example.soomgo.chattFragment

import android.os.Bundle
import android.view.View
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentChattBinding


class ChattFragment : BaseFragment<FragmentChattBinding>(FragmentChattBinding::bind,
    R.layout.fragment_chatt
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}