package com.affan.cuwaca.presentation.detail_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.affan.cuwaca.R
import com.affan.cuwaca.base.BaseFragment
import com.affan.cuwaca.data.model.CurrentWeatherResponse
import com.affan.cuwaca.databinding.FragmentDetailWeatherBinding
import com.affan.cuwaca.presentation.detail_screen.viewmodel.DetailCurrentWeatherViewModel
import com.affan.cuwaca.presentation.home_screen.view.HomeCurrentWeatherFragment
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCurrentWeatherFragment : BaseFragment<FragmentDetailWeatherBinding>() {
    private val viewDetailCurrentWeatherModel: DetailCurrentWeatherViewModel by viewModels()
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailWeatherBinding {
        return FragmentDetailWeatherBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        handleClick()
        viewDetailCurrentWeatherModel.getDetailCuwaca()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewDetailCurrentWeatherModel.detailCuwaca.observe(viewLifecycleOwner){
            setUpDetailCurrentWeatherView(it)
        }
    }

    private fun setUpDetailCurrentWeatherView(data : CurrentWeatherResponse) {
        binding.tvDetailCity.text = data.name.toString()
        binding.tvNameWeather.text = data.weather[0].main.toString()
        binding.tvDetailTemp.text = data.main.temp.toString()
        binding.tvDetailDescWeather.text = data.weather[0].description.toString()
        binding.tvDetailHumidity.text = data.main.humidity.toString()
        binding.tvDetailFeelslike.text = data.main.feelsLike.toString()
        binding.tvDetailTempMin.text = data.main.tempMin.toString()
        binding.tvDetailTempMax.text = data.main.tempMax.toString()
        binding.tvDetailSpeedWind.text = data.wind.speed.toString()
        binding.tvDetailWindDeg.text = data.wind.deg.toString()
        binding.tvDetailPressure.text = data.main.pressure.toString()
        binding.tvDetailClouds.text = data.clouds.all.toString()

        // load image dengan glide
        val imageCode = data.weather[0].icon
        Glide.with(binding.root.context)
            .load("https://openweathermap.org/img/wn/$imageCode@2x.png?")
            .override(160, 80)
            .centerCrop()
            .into(binding.ivDetailWeather)
    }
    private fun handleClick() {
        binding.ButtonDetaiBack.setOnClickListener {
            val newFragment = HomeCurrentWeatherFragment()
            // Lakukan transaksi fragment untuk menggantikan fragment saat ini dengan fragment baru
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, newFragment)
                .addToBackStack(null) // Tambahkan ke back stack agar dapat kembali ke fragment sebelumnya
                .commit()
        }
    }
}