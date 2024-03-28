package com.affan.cuwaca.di

import com.affan.cuwaca.data.WeatherService
import com.affan.cuwaca.data.remote.CurrentWeatherResponseRemote
import com.affan.cuwaca.data.remote.CurrentWeatherResponseRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CurrentWeatherModule {
    @Singleton
    @Provides
    fun provideCurrentWeatherRemoteDataSource(service : WeatherService) : CurrentWeatherResponseRemote {
        return CurrentWeatherResponseRemoteImpl(service)
    }
}