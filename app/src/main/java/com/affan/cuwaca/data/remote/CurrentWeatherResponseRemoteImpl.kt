package com.affan.cuwaca.data.remote

import com.affan.cuwaca.data.WeatherService
import com.affan.cuwaca.data.model.CurrentWeatherResponse
import retrofit2.Response
import javax.inject.Inject

// @Inject -> digunakan untuk menandai konstruktor atau properti
// yang akan diinjeksi nilainya oleh Dagger (atau framework dependency injection lainnya)
// saat membuat instance dari kelas yang bersangkutan
class CurrentWeatherResponseRemoteImpl @Inject constructor(val service: WeatherService) : CurrentWeatherResponseRemote {

    override suspend fun getCurrentWeather(): Response<CurrentWeatherResponse> {
        return service.getCurrentWeather()
    }
}