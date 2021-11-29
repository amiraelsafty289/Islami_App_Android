package com.example.islamiapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.fragments.HadethFragment
import com.example.islamiapp.ui.home.fragments.QuranFragment
import com.example.islamiapp.ui.home.fragments.RadioFragment
import com.example.islamiapp.ui.home.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation :BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation_bar)
        bottomNavigation.setOnItemSelectedListener {
            menuItem->
            if(menuItem.itemId == R.id.navigation_quran){
                pushFragment(QuranFragment())
            } else if(menuItem.itemId == R.id.navigation_hadeth){
                pushFragment(HadethFragment())
            } else if(menuItem.itemId == R.id.navigation_sebha){
                pushFragment(SebhaFragment())
            } else if(menuItem.itemId == R.id.navigation_radio){
                pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigation.selectedItemId = R.id.navigation_quran

    }

    private fun pushFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}