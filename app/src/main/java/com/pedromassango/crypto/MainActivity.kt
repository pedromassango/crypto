package com.pedromassango.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity :
    AppCompatActivity(),
    NavHost {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // setting up navigation component along with  BottomNavigationView
        NavigationUI.setupWithNavController(bottom_navigation, navController)
        bottom_navigation.setOnNavigationItemSelectedListener {
            navController.navigate(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun getNavController(): NavController =
        Navigation.findNavController(this, nav_host_fragment.id)
}
