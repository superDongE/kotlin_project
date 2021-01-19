package com.example.soomgo.searchgosudetail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivitySearchgosudetailBinding
import com.example.soomgo.searchgosudetail.models.SearchGosuReponse


class SearchGosuDtail :
    BaseActivity<ActivitySearchgosudetailBinding>(ActivitySearchgosudetailBinding::inflate),
    SearchGosuDetailView {
    var idx: String = "100"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra("api_key")) {
            idx = intent.getStringExtra("api_key").toString()
            showLoadingDialog(this)
            SearchGosuDetailService(this).tryGetSearchGosuDetail(idx)
        }

    }

    override fun onResume() {
        super.onResume()
        binding.searchGosuBack.setOnClickListener {
            finish()
        }
    }

    override fun onGetSearchGosuDetailSuccess(response: SearchGosuReponse) {
        dismissLoadingDialog()

        var gosu_detail_profile = response.searchGosuResult.profileImage
        var gosu_name = response.searchGosuResult.userName
        var gosu_maincat = response.searchGosuResult.mainCategory
        var gosu_rating = response.searchGosuResult.reviewGrade
        var gosu_rating_number = response.searchGosuResult.reviewCount
        var gosu_hanjul = response.searchGosuResult.oneLineDescription
        var gosu_auth = response.searchGosuResult.authentication
        var gosu_adress = response.searchGosuResult.activityRegion
        var gosu_contact = response.searchGosuResult.contactTime
        var gosu_creer = response.searchGosuResult.carrer
        var gosu_empoly = response.searchGosuResult.numberOfEmployees
        var gosu_detailstroy = response.searchGosuResult.detailDescription
        var gosu_activityRadius = response.searchGosuResult.activityRadius

        //적용
        Glide.with(this).load(gosu_detail_profile).apply(
            RequestOptions.bitmapTransform(
                RoundedCorners(24)
            )
        )
            .into(binding.gosuDetailProfile)
        binding.gosuName.text = gosu_name
        binding.gosuOnlin.text = gosu_maincat
        binding.gosuRating.rating = gosu_rating
        binding.gosuRatingNumber.text = gosu_rating_number.toString()
        binding.gosuHanjul.text = gosu_hanjul
        if (gosu_auth == "Y") {
            binding.gosuAuth.text = "본인인증"
        } else {
            binding.gosuAuth.text = "미인증"
        }
        binding.gosuAdress.text = "${gosu_adress} / ${gosu_activityRadius}"
        binding.gosuContact.text = "연락 가능 시간 : ${gosu_contact}"
        binding.gosuCreer.text = "경력 ${gosu_creer}"
        binding.gosuEmpoly.text = "직원수 ${gosu_empoly}"
        binding.gosuDetailstroy.text = gosu_detailstroy

    }

    override fun onGetSearchGosuDetailFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}