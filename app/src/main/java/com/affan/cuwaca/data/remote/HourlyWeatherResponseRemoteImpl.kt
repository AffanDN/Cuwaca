package com.affan.cuwaca.data.remote

import com.affan.cuwaca.data.WeatherService
import com.affan.cuwaca.data.model.HourlyWeatherResponse
import retrofit2.Response
import javax.inject.Inject

class HourlyWeatherResponseRemoteImpl @Inject constructor(val service: WeatherService) : HourlyWeatherResponseRemote {
    override suspend fun getHourlyWeather(): Response<HourlyWeatherResponse> {
        return service.getHourlyWeather()
    }
}