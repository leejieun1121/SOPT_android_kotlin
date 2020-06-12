package com.example.webtoonproject

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.webtoonproject.DivideFragment.*

class WebtoonAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> NewFragment()
            1-> MonFragment()
            2->TueFragment()
            3->WedFragment()
            4->ThuFragment()
            5->FriFragment()
            6->SatFragment()
            7->SunFragment()
            else ->FinalFragment()
        }
    }

    override fun getCount()=9

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "신작"
            1-> "월"
            2-> "화"
            3-> "수"
            4-> "목"
            5-> "금"
            6-> "토"
            7->"일"

            else -> {return "완결"}
        }
    }

}

