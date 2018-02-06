package com.example.logonrm.a21games

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_game -> {
                changeFragment(GameFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sobre -> {
                changeFragment(SobreFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sair -> {
                finish()
            }
        }
        false
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(GameFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
