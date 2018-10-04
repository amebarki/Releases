package com.manga.mebaad.mangarelease.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.manga.mebaad.mangarelease.R
import android.widget.Toast




class HomeActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.activity_toolbar)
        toolbar.title = "Manga Releases"
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.home_bottom_navigation)?.let {
            bottomNavigationView -> NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu_toolbar, menu)
        return true
    }

}
