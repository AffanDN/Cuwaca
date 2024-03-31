package com.affan.cuwaca.presentation.detail_screen.viewmodel

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
class DetailCurrentWeatherViewModel @Inject constructor(private val currentWeatherResponse: CurrentWeatherResponseRemote)  : ViewModel() {
    // Setter
    private val _detailCuwaca = MutableLiveData<CurrentWeatherResponse>()
    // Getter
    val detailCuwaca: LiveData<CurrentWeatherResponse> get() = _detailCuwaca

    // Cek Error dengan membuat variabel
    // Setter
    private val _dataDetailError = MutableLiveData<String>()
    // Getter
    val dataDetailError: LiveData<String> get() = _dataDetailError

    // isi data home cuwaca
    fun getDetailCuwaca() = viewModelScope.launch(Dispatchers.IO){
        currentWeatherResponse.getCurrentWeather().let {
            if (it.isSuccessful){
                _detailCuwaca.postValue(it.body())
            } else {
                _dataDetailError.postValue(it.message())
            }
        }
    }
}