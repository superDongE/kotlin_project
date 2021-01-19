package com.example.soomgo

import android.os.Bundle
import android.util.Log
import com.example.soomgo.chattFragment.ChattFragment
import com.example.soomgo.config.ApplicationClass.Companion.User_Message
import com.example.soomgo.config.ApplicationClass.Companion.User_Name
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.example.soomgo.join.MyprofileFragment
import com.example.soomgo.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.soomgo.config.ApplicationClass.Companion.sSharedPreferences
import com.example.soomgo.detailProfileFragment.DetailProfileFragment
import com.example.soomgo.homeFragment.HomeFragment
import com.example.soomgo.reciverFragment.ReciverFragment
import com.example.soomgo.searchgosuFragment.SearchgosuFragment


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    val key = sSharedPreferences.getString(User_Message, "").toString()
    val useName = sSharedPreferences.getString(X_ACCESS_TOKEN, "User_Name").toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (key != "") {
            showCustomToast("$key")
        }
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()


        binding.mainBtmNav.itemIconTintList = null
    }

    override fun onStart() {
        super.onStart()
        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_searchgosu -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchgosuFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_receive -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ReciverFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_chatt -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ChattFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_myprofile -> {
                        var nn = sSharedPreferences.getString(X_ACCESS_TOKEN, "X-ACCESS-TOKEN")
                            .toString()
                        Log.d("1q2w3e4r", "${nn}+의 값이 없습니다.")    //X-ACCESS-TOKEN
                        if (nn == "X-ACCESS-TOKEN" || nn == "X_ACCESS_TOKEN") {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyprofileFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        } else {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, DetailProfileFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true

                        }
                    }

                }
                false
            })
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        var nn = sSharedPreferences.getString(X_ACCESS_TOKEN, "X_ACCESS_TOKEN").toString()
        if (nn == "X_ACCESS_TOKEN" || nn == "X-ACCESS-TOKEN") {
            supportFragmentManager.beginTransaction()
                .detach(DetailProfileFragment())
                .attach(MyprofileFragment())
                .commitAllowingStateLoss()
        }else {
            supportFragmentManager.beginTransaction()
                .detach(MyprofileFragment())
                .attach(DetailProfileFragment())
                .commitAllowingStateLoss()
        }

    }

    override fun onRestart() {
        super.onRestart()

    }
}






