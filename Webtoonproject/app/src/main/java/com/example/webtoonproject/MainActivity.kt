package com.example.webtoonproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewPager.adapter =
            MainPagerAdapter(
                supportFragmentManager
            )
        main_viewPager.offscreenPageLimit = 5
        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {  }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {   }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_webtoon -> main_viewPager.currentItem = 0
                R.id.menu_recommand -> main_viewPager.currentItem = 1
                R.id.menu_best -> main_viewPager.currentItem = 2
                R.id.menu_mine -> main_viewPager.currentItem = 3
                R.id.menu_more -> main_viewPager.currentItem = 4
            }
            true
        }


    }
}
