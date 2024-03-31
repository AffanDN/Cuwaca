package com.affan.cuwaca.presentation.home_screen.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.affan.cuwaca.R
import com.affan.cuwaca.databinding.ActivityHomeBinding
import com.affan.cuwaca.databinding.FragmentDashboardBinding
import com.affan.cuwaca.presentation.detail_screen.view.DetailCurrentWeatherFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        replacedFragment(HomeCurrentWeatherFragment())

    }

    private fun replacedFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}