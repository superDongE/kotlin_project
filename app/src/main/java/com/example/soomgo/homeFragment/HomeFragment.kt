package com.example.soomgo.homeFragment

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentHomeBinding
import com.example.soomgo.homeFragment.models.HomeChuchenData
import com.example.soomgo.homeFragment.models.HomeServiceData
import com.example.soomgo.lession.LessionActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind,
    R.layout.fragment_home
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        }
        val behavior = toolbar.getLayoutParams().layoutAnimationParameters as AppBarLayout.Behavior?
        if (behavior != null) {
            val valueAnimator = ValueAnimator.ofInt()
            valueAnimator.interpolator = DecelerateInterpolator()
            valueAnimator.addUpdateListener { animation ->
                behavior.topAndBottomOffset = (animation.animatedValue as Int)!!
                toolbar.requestLayout()
            }
            valueAnimator.setIntValues(0, -900)
            valueAnimator.duration = 400
            valueAnimator.start()
        }

        //인기어답터
        var adapter = HomeRecyclerAdapter(this.context!!, dataList)
        binding.homeRecycler.adapter = adapter
        binding.homeRecycler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        //인기어답터

        //추천, 청소, 신규, 겨울 준비도 숨고와 함께
        var adapter1 = HomeRecyclerChuchenAdapter(this.context!!, chcheanData)
        binding.homeChuchenRecycler.adapter = adapter1
        binding.homeChuchenRecycler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        var adapter2 = HomeRecyclerChuchenAdapter(this.context!!, cleanGosu)
        binding.homeCleanRecycler.adapter = adapter2
        binding.homeCleanRecycler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }


        var adapter3 = HomeRecyclerChuchenAdapter(this.context!!, newSerview)
        binding.homePopRecycler.adapter = adapter3
        binding.homePopRecycler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        var adapter4 = HomeRecyclerChuchenAdapter(this.context!!, compaign)
        binding.homeRudnfRecycler.adapter = adapter4
        binding.homeRudnfRecycler.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        binding.hommeLession.setOnClickListener {
            startActivity(Intent(this.context, LessionActivity::class.java))
        }


    }
    companion object {
        val dataList = arrayListOf(
            HomeServiceData("비즈니스 영어", "ad38c"),
            HomeServiceData("화상영어/전화영어 회화", "featured_servic"),
            HomeServiceData("TOEIC/speaking/writing 과외", "featured_81"),
            HomeServiceData("수학 과외", "asdasd95b493f1"),
            HomeServiceData("TOEFL", "featured_service_7"),
            HomeServiceData("국어 과외", "service409"),
            HomeServiceData("OPIc 과외", "featured_service"),
            HomeServiceData("IELTS 과외", "featured_service_f"),
            HomeServiceData("과학 과외", "service_popular_407")
        )

        val chcheanData = arrayListOf(
            HomeChuchenData(
                "원룸/소형 이사",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/a4d31b06-1f32-4042-9e44-2c82dd800078.jpg"
            ),
            HomeChuchenData(
                "블로그 마케팅",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/f173d21e-0f55-466f-93a7-e0f0c7fdf3b4.jpg"
            ),
            HomeChuchenData(
                "영어 과외",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/05389ab5-c05d-45c8-abe1-d0b90019cb75.png"
            ),
            HomeChuchenData(
                "철거",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/36ca822b-d084-47c8-b39b-98b65915c892.jpg"
            ),
            HomeChuchenData(
                "아파트 인테리어",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/9e8063c6-e6d7-49db-8e3b-6b09a62464b6.png"
            ),
            HomeChuchenData(
                "기업/상업용 영상 촬영",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/59ef83c5-63bf-4152-a9f8-8e0454638112.png"
            ),
            HomeChuchenData(
                "보험 설계",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/d85ef77a-fcde-4a8e-a9b6-8fb8b1e2d814.jpg"
            )
        )

        val cleanGosu = arrayListOf(
            HomeChuchenData(
                "방역소독",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/ee10a787-199d-40d2-845d-cdfce5419d74.jpg"
            ),
            HomeChuchenData(
                "이사/입주 청소 업체",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/71c1ef33-506c-44de-9663-04cbf241fddd.png"
            ),
            HomeChuchenData(
                "거주 청소 업체",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/17b263cc-cc39-4c1e-bf52-22b41c15b39f.jpg"
            ),
            HomeChuchenData(
                "세탁기 청소",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/7ab9aadc-14e7-4632-a47d-a2dcae5b2b0e.png"
            ),
            HomeChuchenData(
                "집 청소 도우미",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/5ef18e9d-e40b-4673-9252-ca211fb3efd0.jpg"
            ),
            HomeChuchenData(
                "침대/매트리스 청소",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/87e5d4ee-38f6-4e32-b041-3f29e4f6e4b0.png"
            ),
            HomeChuchenData(
                "사무실/상업공간 청소 업체",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/5fd0c7fe-0ce4-4804-8765-dfeec5c2fa52.jpg"
            ),
            HomeChuchenData(
                "보일러/수도 배관 청소",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/72d57d0d-6b99-41d0-9532-24c68b513ba0.png"
            ),
        )

        val newSerview = arrayListOf(
            HomeChuchenData(
                "주택 리모델링",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/featured_service_3f7f1b5e-2124-437f-9463-38c9637102be.png"
            ),
            HomeChuchenData(
                "벽화 시공",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/featured_service_7dd24866-5cf7-4624-aabf-1585a8da1eea.png"
            ),
            HomeChuchenData(
                "집 수리",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/featured_service_2203158f-88cb-4058-8b1e-9cad0e696621.png"
            ),
            HomeChuchenData(
                "벽난로 설치/수리",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/ba15c965-0412-4ffa-b580-ad565afcd065.png"
            ),
        )
        val compaign = arrayListOf(
            HomeChuchenData(
                "보일러 설치",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/de694a5e-edac-4534-97f3-4a84383f4922.png"
            ),
            HomeChuchenData(
                "단열/결로 시공",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/4a7da657-d3b6-42b0-b537-3f46440b40cd.jpg"
            ),
            HomeChuchenData(
                "도어 시공",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/7ab170a4-707e-4274-9b78-cf903b360158.png"
            ),
            HomeChuchenData(
                "단열필름 시공",
                "https://dmmj3ljielax6.cloudfront.net/upload/service/d26ced51-f8f0-4a6e-89a1-7fbb0ce786c6.jpg"
            ),
        )

    }




}