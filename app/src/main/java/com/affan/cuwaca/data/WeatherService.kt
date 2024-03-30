package com.affan.cuwaca.data

import com.affan.cuwaca.data.model.CurrentWeatherResponse
import com.affan.cuwaca.data.model.HourlyWeatherResponse
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {
    @GET("https://api.openweathermap.org/data/2.5/weather?lat=-6.199929662592764&lon=106.85532153810563&appid=c079843dbc0ce225cc2b054aa0efe238&units=metric")
    suspend fun getCurrentWeather() : Response<CurrentWeatherResponse>

    @GET("https://api.openweathermap.org/data/2.5/forecast?lat=-6.199929662592764&lon=106.85532153810563&appid=c079843dbc0ce225cc2b054aa0efe238&units=metric")
    suspend fun getHourlyWeather() : Response<HourlyWeatherResponse>
}