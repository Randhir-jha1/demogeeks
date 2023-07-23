package com.demo.demogeeks.classtenth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.demo.demogeeks.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class BottomNavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val  bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectListner)
         if (savedInstanceState ==null){
             bottomNavigationView.selectedItemId = R.id.nav_item_home
         }

    }

    private val onNavigationItemSelectListner = BottomNavigationView.OnNavigationItemSelectedListener{

        when(it.itemId){
            R.id.nav_item_home->{
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_item_dashboard->{
                replaceFragment(DashBoardFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_item_setting->{
                replaceFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true

            }
        }
        false

    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flScreen,fragment)
            .commit()
    }

}