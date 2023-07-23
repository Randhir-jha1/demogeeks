package com.demo.demogeeks.classtenth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.demo.demogeeks.R
import com.google.android.material.tabs.TabLayout

class TabFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_fragment)

        val viewpager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val fragmentList = listOf(HomeFragment(),DashBoardFragment(),SettingsFragment())
        val fragmentTitles = listOf("Home","Dashboard","Settings")

        val pageradapter = MyPagerAdapter(supportFragmentManager,fragmentList,fragmentTitles)
        viewpager.adapter = pageradapter

        tabLayout.setupWithViewPager(viewpager)
    }
}