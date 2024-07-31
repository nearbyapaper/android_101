package com.example.neardroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestMaterialDesignActivity : AppCompatActivity() {
    private var bottomNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_material_design)

        bottomNav = findViewById(R.id.bottom_navigation)
        Log.d("1995", "bottomNav :: $bottomNav")
        initFragment()
        setBottomNav()
    }

    private fun initFragment() {
        Log.d("1995", "initFragment for TestMaterialDesignActivity ::")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_bottom_nav_layout, BottomNavFavouriteFragment())
            commit()
        }
    }

    private fun setBottomNav() {
        bottomNav?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    Log.d("1995", "page_1 ::")
                    // Respond to navigation item fav click
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_bottom_nav_layout, BottomNavFavouriteFragment())
                        commit()
                    }
                    true
                }
                R.id.page_2 -> {
                    Log.d("1995", "page_2 ::")
                    // Respond to navigation item music click
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_bottom_nav_layout, BottomNavMusicFragment())
                        commit()
                    }
                    true
                }
                R.id.page_3 -> {
                    Log.d("1995", "page_3 ::")
                    // Respond to navigation item places click
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_bottom_nav_layout, BottomNavPlaceFragment())
                        commit()
                    }
                    true
                }
                R.id.page_4 -> {
                    Log.d("1995", "page_4 ::")
                    // Respond to navigation item news click
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_bottom_nav_layout, BottomNavNewsFragment())
                        commit()
                    }
                    true
                }
                else -> {
                    Log.d("1995", "can't find page ::")
                    false
                }
            }
        }
    }
}
