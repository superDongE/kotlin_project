package com.example.soomgo.qustionlast

import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.soomgo.MainActivity
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityQuestionlastBinding
import com.example.soomgo.questionDetail.QustionDetail
import com.example.soomgo.qustionlast.models.GosuFindResponse
import com.example.soomgo.qustionlast.models.QuestionLastRepose
import com.example.soomgo.qustionlast.models.QustionLastRequest

class QuestionLastActivity :
    BaseActivity<ActivityQuestionlastBinding>(ActivityQuestionlastBinding::inflate),
    QuestionLastView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val idx: String = "5"
        binding.button.setOnClickListener {
            showLoadingDialog(this)
            val postRequest = QustionLastRequest(
                categoryIdx = 5,
                firstQuestion = 1,
                firstAnswer = 1,
                secondQuestion = 2,
                secondAnswer = 8,
                thirdQuestion = 3,
                thirdAnswer = 10,
                fourthQuestion = 4,
                userRegion = "서울 강남구"
            )
            QuestionLastServie(this).tryPostQustionLast(postRequest)
            QuestionLastServie(this).tryGetGosuSearch(idx)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onPostQusestionLastSuccess(reponse: QuestionLastRepose) {
        dismissLoadingDialog()


    }

    override fun onPostQusestionLastFailure(message: String) {
        dismissLoadingDialog()

    }

    override fun onGetGosuSearchSuccess(response: GosuFindResponse) {
        dismissLoadingDialog()
    }

    override fun onGetGosuSearchFailure(message: String) {
        dismissLoadingDialog()
    }
}