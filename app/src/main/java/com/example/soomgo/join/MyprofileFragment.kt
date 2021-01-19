package com.example.soomgo.join

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentMyprofileBinding
import com.example.soomgo.login.LoginActivity

class MyprofileFragment: BaseFragment<FragmentMyprofileBinding>(FragmentMyprofileBinding::bind,
    R.layout.fragment_myprofile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginJoin.setOnClickListener {
            startActivity(Intent(this.context, LoginActivity::class.java))
        }


    }
}