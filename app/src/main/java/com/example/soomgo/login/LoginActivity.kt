package com.example.soomgo.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.soomgo.R
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityLoginBinding
import com.example.soomgo.join.JoinActivity
import com.example.soomgo.login.models.PostSignInRequest
import com.example.soomgo.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.soomgo.config.ApplicationClass.Companion.sSharedPreferences
import com.example.soomgo.config.ApplicationClass.Companion.User_Name
import com.example.soomgo.config.ApplicationClass.Companion.User_Email
import com.example.soomgo.config.ApplicationClass.Companion.User_Message
import com.example.soomgo.config.ApplicationClass.Companion.User_Password
import com.example.soomgo.login.models.SignInResponse


class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    LoginActivityView {

    var responseJWT: String? = sSharedPreferences.getString(X_ACCESS_TOKEN, "")
    var responseName: String? = sSharedPreferences.getString(User_Name, "")
    var responseEmail: String? = sSharedPreferences.getString(User_Email, "")
    var responseMessage: String? = sSharedPreferences.getString(User_Message, "")
    var responsePassword: String? = sSharedPreferences.getString(User_Password, "")
    var password: String = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //toolbar
        setSupportActionBar(binding.newjoinToolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(true)     //타이틀바 생성
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)    //텍스트바 없애기
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)    //백키

        binding.newjoinJoin.setOnClickListener {
            //회원가입  액티비티 시작
            startActivity(Intent(this, JoinActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.emailLogin.setOnClickListener {
            val email = binding.newjoinEmailEdit.text.toString()
            password = binding.newjoinPwEdit.text.toString()
            val postRequest = PostSignInRequest(email = email, password = password)
            responsePassword = password
            showLoadingDialog(this!!)
            LoginService(this).tryPostSignIn(postRequest)
        }

    }


    override fun onPostSignInSuccess(response: SignInResponse) {
        responseJWT = response.jwt
        responseName = response.result.userName
        responseEmail = response.result.email
        responseMessage = response.message
        val edit = sSharedPreferences.edit()
        edit.putString(X_ACCESS_TOKEN, responseJWT)
        edit.putString(User_Name, responseName)
        edit.putString(User_Email, responseEmail)
        edit.putString(User_Message, responseMessage)
        edit.putString(User_Password, password)
        edit.commit()

        dismissLoadingDialog()
        finish()
    }

    override fun onPostSignInFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_newjoin, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 결정하는 것
        when (item.itemId) {
            R.id.left_arrow -> finish()   // 홈으로 이동
        }
        return super.onOptionsItemSelected(item)
    }
}

