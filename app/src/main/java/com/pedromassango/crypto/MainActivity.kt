package com.pedromassango.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity :
    AppCompatActivity(),
    NavHost {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    override fun getNavController(): NavController =
        Navigation.findNavController(this, nav_host_fragment.id)
}
