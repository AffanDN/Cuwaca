package com.affan.cuwaca.data.remote

import com.affan.cuwaca.data.model.CurrentWeatherResponse
import retrofit2.Response

// membuat kerangka untuk fungsi getCurrentWeather

interface CurrentWeatherResponseRemote {
    // suspend -> Ketika fungsi suspend dipanggil,
    // ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    suspend fun getCurrentWeather(): Response<CurrentWeatherResponse>
}