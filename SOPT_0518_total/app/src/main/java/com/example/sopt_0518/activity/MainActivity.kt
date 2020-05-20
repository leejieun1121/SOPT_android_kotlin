package com.example.sopt_0518.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sopt_0518.adapter.MainpagerAdapter
import com.example.sopt_0518.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewPager.adapter =
            MainpagerAdapter(supportFragmentManager)
        main_viewPager.offscreenPageLimit = 2
        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //네비게이션 메뉴 아이템 체크
                bottom_navigationview.menu.getItem(position).isChecked = true

            }

        })

        bottom_navigationview.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> main_viewPager.currentItem=0
                R.id.menu_book -> main_viewPager.currentItem=1
                R.id.menu_person -> main_viewPager.currentItem=2

            }
        }

    }

}

