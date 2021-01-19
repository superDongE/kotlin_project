package com.example.soomgo.join


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.soomgo.R
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityJoinBinding
import com.example.soomgo.join.models.PostSignUpRequest
import com.example.soomgo.join.models.SignUpResponse
import com.example.soomgo.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.soomgo.config.ApplicationClass.Companion.sSharedPreferences

class JoinActivity : BaseActivity<ActivityJoinBinding>(ActivityJoinBinding::inflate),
    JoinActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //toolbar
        setSupportActionBar(binding.joinToolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(true)     //타이틀바 생성
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)    //텍스트바 없애기

        binding.linearLayout.setOnClickListener {
            binding.linearimg1.setImageResource(R.drawable.check_change)
            binding.linearLayout.setBackgroundResource(R.drawable.btn_round)
            binding.linearimg2.setImageResource(R.drawable.check_box)
            binding.linearLayout2.setBackgroundResource(R.drawable.btn_round_no)
        }
        binding.linearLayout2.setOnClickListener {
            binding.linearimg2.setImageResource(R.drawable.check_change)
            binding.linearLayout2.setBackgroundResource(R.drawable.btn_round)
            binding.linearimg1.setImageResource(R.drawable.check_box)
            binding.linearLayout.setBackgroundResource(R.drawable.btn_round_no)
        }

        binding.joinYark.setOnClickListener {
            binding.joinYark.setImageResource(R.drawable.check_change)
        }

    }

    override fun onResume() {
        super.onResume()
        binding.btnNewcreate.setOnClickListener {
            val name = binding.joinName.text.toString()
            val email = binding.joinEmail.text.toString()
            val password = binding.joinPwd.text.toString()
            val repassword = binding.joinRepwd.text.toString()
            val postRequset = PostSignUpRequest(
                name = name,
                email = email,
                password = password,
                repassword = repassword
            )
            showLoadingDialog(this)
            JoinService(this).tryPostSignUp(postRequset)
        }
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {

        when(response.isSuccess.toString()){
            "true"->{
                val edit = sSharedPreferences.edit()

                edit.putString(X_ACCESS_TOKEN, response.jwt)
                dismissLoadingDialog()
                finish()
            }
       }

    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_join, menu)

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