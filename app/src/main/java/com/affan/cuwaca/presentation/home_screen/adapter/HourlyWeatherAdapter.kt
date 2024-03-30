package com.affan.cuwaca.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.affan.cuwaca.data.model.ForecastDataHourly
import com.affan.cuwaca.databinding.ItemHourlyWeatherBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date

class HourlyWeatherAdapter(private val data: List<ForecastDataHourly>) :
    RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewHolder>(){

    inner class HourlyWeatherViewHolder(val binding: ItemHourlyWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ForecastDataHourly) {
            val forecastTime = convertUnixTimeToDate(data.dt)
            val formattedTime =
                SimpleDateFormat("HH:mm").format(forecastTime) // format : dd/MM/yyyy HH:mm

            binding.tvHourlyHour.text = formattedTime
            binding.tvHourlyWeather.text = data.weather[0].main.toString()
            binding.tvHourlyCelcius.text = data.main.temp.toString()
            binding.tvHourlyDescWeather.text = data.weather[0].description.toString()
            binding.tvHourlyHumidity.text = data.main.humidity.toString()
            binding.tvHourlySpeedWind.text = data.wind.speed.toString()

            // load image dengan glide
            val imageCode = data.weather[0].icon
            Glide.with(binding.root.context)
                .load("https://openweathermap.org/img/wn/$imageCode@2x.png?")
                .override(160, 80)
                .centerCrop()
                .into(binding.ivHourlyImageWeather)
        }

        private fun convertUnixTimeToDate(unixTime: Long): Date {
            return Date(unixTime * 1000)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder {
        return HourlyWeatherViewHolder(
            ItemHourlyWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(data[position])
    }
}