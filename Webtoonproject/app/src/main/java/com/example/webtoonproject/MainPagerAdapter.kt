package com.example.webtoonproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.webtoonproject.HomeFragment.*

class MainPagerAdapter  (fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> WebtoonFragment()
            1 -> RecommandFragment()
            2 -> BestFragment()
            3 -> MyFragment()
            else -> MoreFragment()

        }
    }

    override fun getCount() = 5
}