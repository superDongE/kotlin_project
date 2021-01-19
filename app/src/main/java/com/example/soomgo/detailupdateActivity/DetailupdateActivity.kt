package com.example.soomgo.detailupdateActivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityDetailupdateBinding
import android.view.Menu
import android.view.MenuItem
import com.example.soomgo.R
import com.example.soomgo.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.soomgo.config.ApplicationClass.Companion.sSharedPreferences
import com.example.soomgo.config.ApplicationClass.Companion.User_Name
import com.example.soomgo.config.ApplicationClass.Companion.User_Email
import com.example.soomgo.config.ApplicationClass.Companion.User_Message
import com.example.soomgo.config.ApplicationClass.Companion.User_Password

class DetailupdateActivity :
    BaseActivity<ActivityDetailupdateBinding>(ActivityDetailupdateBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.detalprofileToolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(true)     //타이틀바 생성
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)    //텍스트바 없애기
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)    //백키


        binding.updateName.text = sSharedPreferences.getString(User_Name, "")
        binding.updateEmail.text = sSharedPreferences.getString(User_Email, "")
        binding.updatePassword.text = sSharedPreferences.getString(User_Password, "")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_detail_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 결정하는 것
        when (item.itemId) {
            R.id.left_logout -> {
                val edit = sSharedPreferences.edit()
                edit.putString(X_ACCESS_TOKEN, "X_ACCESS_TOKEN")
                edit.putString(User_Name, "")
                edit.putString(User_Message, "")
                edit.putString(User_Email, "")
                    .commit()
                finish()
            }   // 홈으로 이동
        }
        return super.onOptionsItemSelected(item)
    }
}