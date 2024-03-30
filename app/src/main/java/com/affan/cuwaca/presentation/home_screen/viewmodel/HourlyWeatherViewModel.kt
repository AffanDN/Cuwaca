package com.affan.cuwaca.presentation.home_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.affan.cuwaca.data.model.CurrentWeatherResponse
import com.affan.cuwaca.data.model.HourlyWeatherResponse
import com.affan.cuwaca.data.remote.HourlyWeatherResponseRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HourlyWeatherViewModel @Inject constructor(private val hourlyWeatherResponse: HourlyWeatherResponseRemote)  : ViewModel() {

    // Setter
    private val _homeHourlyCuwaca = MutableLiveData<HourlyWeatherResponse>()
    // Getter
    val homeHourlyCuwaca: LiveData<HourlyWeatherResponse> get() = _homeHourlyCuwaca

    // Cek Error dengan membuat variabel
    // Setter
    private val _dataHourlyError = MutableLiveData<String>()
    // Getter
    val dataHourlyError: LiveData<String> get() = _dataHourlyError

    fun getHomeHourlyCuwaca() = viewModelScope.launch(Dispatchers.IO){
        hourlyWeatherResponse.getHourlyWeather().let {
            if (it.isSuccessful){
                _homeHourlyCuwaca.postValue(it.body())
            } else {
                _dataHourlyError.postValue(it.message())
            }
        }
    }
}