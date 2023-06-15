package com.test.study01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.test.study01.databinding.ActivityMainBinding
import com.test.study01.databinding.FragmentFirstBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBingind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        activityMainBingind = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityMainBingind.root)

        activityMainBingind.run {

            //viewPager2에 어댑터 연결하기
            viewPager2.adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

            tabLayout.run {
                addOnTabSelectedListener(object : OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        if (tab != null) {
                            viewPager2.currentItem = tab.position
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {

                    }

                })
            }

            viewPager2.run {
                registerOnPageChangeCallback(object : OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        tabLayout.selectTab(tabLayout.getTabAt(position))
                    }
                })
            }
        }
    }
}


