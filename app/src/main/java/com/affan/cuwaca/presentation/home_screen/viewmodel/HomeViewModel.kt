package com.affan.cuwaca.presentation.home_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.affan.cuwaca.data.model.CurrentWeatherResponse
import com.affan.cuwaca.data.remote.CurrentWeatherResponseRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val currentWeatherResponse: CurrentWeatherResponseRemote)  : ViewModel() {

    // Setter
    private val _homeCuwaca = MutableLiveData<CurrentWeatherResponse>()
    // Getter
    val homeCuaca: LiveData<CurrentWeatherResponse> get() = _homeCuwaca

    // Cek Error dengan membuat variabel
    // Setter
    private val _dataError = MutableLiveData<String>()
    // Getter
    val dataError: LiveData<String> get() = _dataError

    // isi data home cuwaca
    fun getHomeCuwaca() = viewModelScope.launch(Dispatchers.IO){
        currentWeatherResponse.getCurrentWeather().let {
            if (it.isSuccessful){
                _homeCuwaca.postValue(it.body())
            } else {
                _dataError.postValue(it.message())
            }
        }
    }

}