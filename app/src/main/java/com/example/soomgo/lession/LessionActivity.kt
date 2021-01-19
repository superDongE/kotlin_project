package com.example.soomgo.lession

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.soomgo.R
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityLessionBinding
import com.google.android.material.tabs.TabLayoutMediator

class LessionActivity : BaseActivity<ActivityLessionBinding>(ActivityLessionBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabLayoutTextArray = arrayOf("인기", "학업", "외국어", "외국어시험", "공예", "미술", "음악이론/보컬")

        //toolbar
        setSupportActionBar(binding.lessionToolbar)
//        getSupportActionBar()?.setDisplayShowTitleEnabled(true)     //타이틀바 생성
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)    //텍스트바 없애기
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)    //백키

        //연결
       binding.lessionViewpager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.lessionViewpager){tab, postistion ->
            tab.text = tabLayoutTextArray[postistion]
        }.attach()


    }

    override fun onResume() {
        super.onResume()
        binding.lession.setOnClickListener {
            // 레이아웃 클릭시

            if(binding.lessionTablelinear.visibility == View.VISIBLE){
                binding.lessionTablelinear.visibility = View.GONE
                binding.lessiomLetterX.visibility = View.GONE
                binding.lessionArrow.setImageResource(R.drawable.abc1)
                binding.tabLayout.alpha= 1.0F
                binding.lessionViewpager.alpha= 1.0F
            }else{
                binding.tabLayout.alpha= 0.4F
                binding.lessionViewpager.alpha= 0.4F
                binding.lessionArrow.setImageResource(R.drawable.abc2)
                binding.lessiomLetterX.visibility = View.VISIBLE
                binding.lessionTablelinear.visibility = View.VISIBLE
            }
            binding.lessiomLetterX.setOnClickListener {
                binding.lessionTablelinear.visibility = View.GONE
                binding.lessiomLetterX.visibility = View.GONE
                binding.lessionArrow.setImageResource(R.drawable.abc1)
                binding.tabLayout.alpha= 1.0F
                binding.lessionViewpager.alpha= 1.0F
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuInflater = menuInflater
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 결정하는 것
//        when (item.itemId) {
//            R.id.main -> {
//
//            }
//        }
        return super.onOptionsItemSelected(item)
    }


}