package com.example.sopt_0518.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sopt_0518.fragment.HomeFragment
import com.example.sopt_0518.fragment.LibraryFragment
import com.example.sopt_0518.fragment.MyPageFragment

class MainpagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> HomeFragment()
            1-> LibraryFragment()
            else -> MyPageFragment()
        }
    }

    override fun getCount()=3

}