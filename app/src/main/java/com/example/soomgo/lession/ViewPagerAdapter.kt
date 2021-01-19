package com.example.soomgo.lession

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.soomgo.arts.FragmentArts
import com.example.soomgo.craft.FragmentCraft
import com.example.soomgo.english.FragmentEnglish
import com.example.soomgo.engtest.FragmentEngTest
import com.example.soomgo.music.FragmentMusic
import com.example.soomgo.papularity.FragmentPopularity
import com.example.soomgo.study.FragmentStudy

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentPopularity()
            1 -> FragmentStudy()
            2 -> FragmentEnglish()
            3 -> FragmentEngTest()
            4 -> FragmentCraft()
            5 -> FragmentArts()
            6 -> FragmentMusic()
            else -> FragmentStudy()
        }
    }

    override fun getItemCount(): Int = 7
}