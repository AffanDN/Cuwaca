package com.affan.cuwaca.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.affan.cuwaca.R
import com.affan.cuwaca.base.BaseFragment
import com.affan.cuwaca.data.model.CurrentWeatherResponse
import com.affan.cuwaca.data.model.ForecastDataHourly
import com.affan.cuwaca.databinding.FragmentDashboardBinding
import com.affan.cuwaca.presentation.home_screen.adapter.HourlyWeatherAdapter
import com.affan.cuwaca.presentation.home_screen.viewmodel.HomeViewModel
import com.affan.cuwaca.presentation.home_screen.viewmodel.HourlyWeatherViewModel
import com.affan.cuwaca.util.HorizontalItemDecoration
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeCurrentWeatherFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewHomeCurrentWeatherModel: HomeViewModel by viewModels()
    private val viewHomeHourlyWeatherModel: HourlyWeatherViewModel by viewModels()

    private lateinit var hourlyWeatherAdapter: HourlyWeatherAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewHomeCurrentWeatherModel.getHomeCuwaca()
        viewHomeHourlyWeatherModel.getHomeHourlyCuwaca()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewHomeCurrentWeatherModel.homeCuaca.observe(viewLifecycleOwner) {
            setUpCurrentWeatherView(it)
        }
        viewHomeHourlyWeatherModel.homeHourlyCuwaca.observe(viewLifecycleOwner) {
            setUpHourlyWeatherView(it.forecastDataList.subList(0,8)) // sublist untuk slice list berdasarkan index
        }
    }

    private fun setUpCurrentWeatherView(data : CurrentWeatherResponse) {
        binding.iContentTopHeader.tvKota.text = data.name.toString()
        binding.iContentTopHeader.tvTemprature.text = data.main.temp.toString()
        binding.iContentTopHeader.tvWeather.text = data.weather[0].main.toString()

        binding.iContentTopHeader2.tvDescWeather.text = data.weather[0].main.toString()
        binding.iContentTopHeader2.tvHumidity.text = data.main.humidity.toString()
        binding.iContentTopHeader2.tvSpeedWind.text = data.wind.speed.toString()

        // load image dengan glide
        val imageCode = data.weather[0].icon
        Glide.with(binding.root.context)
            .load("https://openweathermap.org/img/wn/$imageCode@2x.png?")
            .override(160, 80)
            .centerCrop()
            .into(binding.iContentTopHeader.ivCurrentWeather)
    }

    private fun setUpHourlyWeatherView(data: List<ForecastDataHourly>) {
        hourlyWeatherAdapter = HourlyWeatherAdapter(data)
        binding.iContentHourly.recycleHourlyWeather.adapter = hourlyWeatherAdapter

        // untuk setting orientasi recycle viewnya, bisa juga secara manual
        // edit orientation di component recycleView
        binding.iContentHourly.recycleHourlyWeather.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )

    }

}