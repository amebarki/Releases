package com.manga.mebaad.mangarelease.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.manga.mebaad.mangarelease.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.home_bottom_navigation)?.let {
            bottomNavigationView -> NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)
        }
    }
}
