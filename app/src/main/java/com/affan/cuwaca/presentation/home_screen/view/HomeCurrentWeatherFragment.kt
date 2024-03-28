package com.affan.cuwaca.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.affan.cuwaca.base.BaseFragment
import com.affan.cuwaca.databinding.FragmentDashboardBinding
import com.affan.cuwaca.presentation.home_screen.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeCurrentWeatherFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewHomeCurrentWeatherModel: HomeViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewHomeCurrentWeatherModel.getHomeCuwaca()
        viewHomeCurrentWeatherModel.homeCuaca.observe(viewLifecycleOwner) {
            binding.iContentTopHeader.tvKota.text = it.name.toString()
            binding.iContentTopHeader.tvTemprature.text = it.main.temp.toString()
            binding.iContentTopHeader.tvWeather.text = it.weather[0].main.toString()

            binding.iContentTopHeader2.tvDescWeather.text = it.weather[0].main.toString()
            binding.iContentTopHeader2.tvHumidity.text = it.main.humidity.toString()
            binding.iContentTopHeader2.tvSpeedWind.text = it.wind.speed.toString()
        }
    }
}