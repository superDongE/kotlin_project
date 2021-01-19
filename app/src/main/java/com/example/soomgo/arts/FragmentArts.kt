package com.example.soomgo.arts

import android.os.Bundle
import android.view.View
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentArtsBinding

class FragmentArts : BaseFragment<FragmentArtsBinding>(FragmentArtsBinding::bind,
    R.layout.fragment_arts
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}