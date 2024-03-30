package com.affan.cuwaca.di

import com.affan.cuwaca.data.WeatherService
import com.affan.cuwaca.data.remote.HourlyWeatherResponseRemote
import com.affan.cuwaca.data.remote.HourlyWeatherResponseRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HourlyWeatherModule {

    @Singleton
    @Provides
    fun provideHourlyWeatherRemoteDataSource(service : WeatherService) : HourlyWeatherResponseRemote {
        return HourlyWeatherResponseRemoteImpl(service)
    }
}