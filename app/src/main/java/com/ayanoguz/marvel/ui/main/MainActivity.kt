package com.ayanoguz.marvel.ui.main

import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ayanoguz.marvel.R
import com.ayanoguz.marvel.core.BaseActivity
import com.ayanoguz.marvel.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {
    lateinit var navController: NavController
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onInit() {
        setListener()
        initNavigation()
    }

    private fun setListener() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initNavigation() {
        navController = Navigation.findNavController(
            this,
            R.id.container
        )
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)

    }


    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.container).navigateUp()


}