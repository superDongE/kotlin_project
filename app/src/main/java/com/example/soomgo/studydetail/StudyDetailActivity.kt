package com.example.soomgo.studydetail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityStudydetailBinding
import com.example.soomgo.questionDetail.QustionDetail
import com.example.soomgo.studydetail.models.StudyDetailResponse

class StudyDetailActivity: BaseActivity<ActivityStudydetailBinding>(ActivityStudydetailBinding::inflate), StudyView {
    var index: String = "100"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if(intent.hasExtra("api_key")){
            index = intent.getStringExtra("api_key").toString()
            showLoadingDialog(this)
            StudyDetailService(this).getStudyDetail(index)
        }
        binding.studyFinish.setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        binding.studyDetail.setOnClickListener {
            startActivity(Intent(this, QustionDetail::class.java))
        }
    }

    override fun onGetStudySuccess(response: StudyDetailResponse) {
        dismissLoadingDialog()
        //컷트
        var v1 = response.result.categoryDescription.split("!")
        Log.d("1q2w3e4r", "$v1")
        //컷트
        var title = response.result.bottomCategoryTitle
        var grade : Float = response.result.grade
        var description = response.result.categoryDescription
        var categoryImge = response.result.categoryImage
        var activityGosu = response.result.activityGosu
        var requestQuantity = response.result.requestQuantity
        var reviewCount = response.result.reviewCount
        Glide.with(this).load(categoryImge).into(binding.studyImg)  // 이미지 입력
        binding.studyTitle.text = title
        binding.studyRatingText.text = grade.toString()
//        binding.studyDescription.text = description
        binding.studyDescription.text = v1[0]
        binding.studydetailText2.text = v1[1]
        binding.studyRating.rating = grade

        binding.studyGosuText.text = activityGosu.toString()
        binding.studyNujeckText.text = requestQuantity.toString()
        binding.studyReviewText.text = reviewCount.toString()



    }


    override fun onGetStudyFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}