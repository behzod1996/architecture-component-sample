package com.behzoddev.architecturecomponentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug","Function onCreate: Body")
        initNavigation()
    }

    private fun initNavigation() {
        Log.d("Debug","Function initNavigation: Body")
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment?
            ?: return
    }
}