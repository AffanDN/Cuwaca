package com.affan.cuwaca.data.remote


import retrofit2.Response
import com.affan.cuwaca.data.model.HourlyWeatherResponse

interface HourlyWeatherResponseRemote {
    suspend fun getHourlyWeather(): Response<HourlyWeatherResponse>
}