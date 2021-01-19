package com.example.soomgo.music

import android.os.Bundle
import android.view.View
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentMusicBinding


class FragmentMusic : BaseFragment<FragmentMusicBinding>(FragmentMusicBinding::bind,
    R.layout.fragment_music
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
