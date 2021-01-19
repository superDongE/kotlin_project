package com.example.soomgo.detailProfileFragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.soomgo.detailupdateActivity.DetailupdateActivity
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentDetailprofileBinding
import com.example.soomgo.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.soomgo.config.ApplicationClass.Companion.sSharedPreferences
import com.example.soomgo.config.ApplicationClass.Companion.User_Name
import com.example.soomgo.config.ApplicationClass.Companion.User_Email


class DetailProfileFragment : BaseFragment<FragmentDetailprofileBinding>(FragmentDetailprofileBinding::bind,
    R.layout.fragment_detailprofile
) {
    val pre = sSharedPreferences.getString(X_ACCESS_TOKEN, "")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(binding.detalprofileToolbar)
            (activity as AppCompatActivity).getSupportActionBar()?.setDisplayShowTitleEnabled(false)    //텍스트바 없애기
        }

        binding.changeText.text = "고수"

    }

    override fun onResume() {
        super.onResume()

        if(pre != null) {
            val userName = sSharedPreferences.getString(User_Name,"").toString()
            val userEmail = sSharedPreferences.getString(User_Email, "").toString()
            binding.detailUserName.text = userName
            binding.detailUserEmail.text = userEmail
        }


        // 개인정보 수정
        binding.detailUserDetail.setOnClickListener {
            startActivity(Intent(this.context, DetailupdateActivity::class.java))
        }
    }



}